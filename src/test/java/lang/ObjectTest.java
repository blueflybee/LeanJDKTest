package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ObjectTest {

  private Object mObj = new Object();
  private boolean flag = false;

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testGetClass() {
    String str = "123456";
    System.out.println("str = " + str.getClass().getSimpleName());
  }

  @Test
  public void testHashCode() {
    Object o1 = new Object();
    Object o2 = new Object();
    System.out.println("o1 = " + o1.hashCode());
    System.out.println("o2 = " + o2.hashCode());

    System.out.println("o1.equals(o2) = " + o1.equals(o2));
  }

  @Test
  public void testEquals() {
    Student student1 = new Student("s1");
    Student student2 = new Student("s2");
    Student student3 = new Student("s1");
    Student student4 = new Student("s1");


    assertTrue(student1.equals(student1));
    assertFalse(student1.equals(null));
    assertFalse(student1.equals(student2));
    assertFalse(student2.equals(student1));

    assertTrue(student1.equals(student3));
    assertTrue(student1.equals(student3));
    assertTrue(student1.equals(student3));
    assertTrue(student3.equals(student1));

    assertTrue(student1.equals(student3));
    assertTrue(student3.equals(student4));
    assertTrue(student1.equals(student4));


  }

  @Test
  public void testClone() throws CloneNotSupportedException {

    Student s1 = new Student("s1");

    Student clone = s1.clone();
    assertNotSame(s1, clone);
    assertSame(s1.getClass(), clone.getClass());
    assertEquals(s1, clone);

    System.out.println("clone.name = " + clone.name);

    String[] strs = new String[]{"a", "b", "c"};
    String[] strsClone = strs.clone();
//    System.out.println("Arrays.toString(strsClone) = " + Arrays.toString(strsClone));

    assertNotSame(strs, strsClone);
    assertSame(strs.getClass(), strsClone.getClass());
    assertArrayEquals(strs, strsClone);

    Student s2 = new Student("s2");
    Student[] students = new Student[]{s1, s2};
    Student[] studentsClone = students.clone();

    assertNotSame(students, studentsClone);
    assertSame(students.getClass(), studentsClone.getClass());
    assertArrayEquals(students, studentsClone);

    System.out.println("students[0] = " + students[0]);
    System.out.println("students[1] = " + students[1]);
    System.out.println("students[1] = " + studentsClone[0]);
    System.out.println("students[1] = " + studentsClone[1]);

    //clone方法默认浅拷贝
    assertSame(students[0], studentsClone[0]);
    assertSame(students[1], studentsClone[1]);
  }

  @Test
  public void testWaitAndNotify() {

    Thread consume = new Thread(new Consume(), "Guest");
    Thread produce = new Thread(new Produce(), "Cook");

    consume.start();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    produce.start();

    try {
      consume.join();
      produce.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }


  private class Student implements Cloneable {
    private String name;

    public Student(String name) {
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || getClass() != o.getClass()) return false;
      if (this == o) return true;

      Student student = (Student) o;

      return name.equals(student.name);
    }

    @Override
    public int hashCode() {
      return name.hashCode();
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
      return (Student) super.clone();
    }
  }


  class Produce implements Runnable {

    @Override
    public void run() {
      synchronized (mObj) {
        System.out.println("Cook:进入生产者线程");
        System.out.println("Cook:开始生产");

        try {
          TimeUnit.MILLISECONDS.sleep(6000);
          //产品已经生产出来
          flag = true;
          mObj.notify();//通知消费者
          System.out.println("Cook:产品已经生产，notify消费者，生产者完成后续工作");
          TimeUnit.MILLISECONDS.sleep(3000);

          System.out.println("Cook:退出生产者线程");

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  class Consume implements Runnable {

    @Override
    public void run() {
      synchronized (mObj) {
        System.out.println("Guest:进入消费者线程");
        System.out.println("Guest:产品已经生产出来了吗？" + flag);

        while (!flag) {//产品还没有生产出来
          try {
            System.out.println("Guest:还没有生产，进入wait.....");
            mObj.wait();
            System.out.println("Guest:产品已经生产，从等待中被唤醒");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        }

        System.out.println("Guest:产品已经生产出来了吗？" + flag);
        System.out.println("Guest:开始消费...");
        try {
          TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Guest:退出消费者线程");

      }
    }
  }


}