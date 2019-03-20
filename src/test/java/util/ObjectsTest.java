package test.java.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static org.junit.Assert.*;

public class ObjectsTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testRequireNonNullWithSupplier() {
//    Object o = new Object();
    Object o = null;
    Objects.requireNonNull(o, new Supplier<String>() {
      @Override
      public String get() {
        return "I'm msg from supplier";
      }
    });

  }

  @Test
  public void testEquals() {
    assertFalse(Objects.equals(new Object(), null));

    assertTrue(Objects.equals(null, null));

    assertFalse(Objects.equals(null, new Object()));
    assertTrue(Objects.equals(1, 1));
    assertTrue(Objects.equals(1f, 1f));

    String a = "a";
    String b = a;

    assertTrue(Objects.equals(a, b));


  }

  @Test
  public void testDeepEquals() {
    String[] strs1 = {
        "1",
        "2",
        "3"
    };

    String[] strs2 = {
        "a",
        "b",
        "c"
    };

    String[] strs3 = {
        "A",
        "B",
        "C"
    };

    String[] strs4 = {
        "1",
        "2",
        "3"
    };

    String[] strs5 = {
        "a",
        "b",
        "c"
    };

    String[] strs6 = {
        "A",
        "B",
        "C"
    };

    String[] strs7 = {
        "A",
        "B",
        "D"
    };
    Object[] objectsA = {
        strs1,
        strs2,
        strs3
    };
    Object[] objectsB = {
        strs4,
        strs5,
        strs6
    };

    Object[] objectsC = {
        strs4,
        strs5,
        strs7
    };
    assertTrue(Objects.deepEquals(null, null));
    assertTrue(Objects.deepEquals(objectsA, objectsB));
    assertFalse(Objects.deepEquals(objectsA, objectsC));

  }

  @Test
  public void testHash() {
    MyObject myObject = new MyObject();
//    myObject.hashCode() = 961868
    System.out.println("myObject.hashCode() = " + myObject.hashCode());

    String a = "a";
    System.out.println("a.hashCode() = " + a.hashCode());
    System.out.println("Objects.hash(a) = " + Objects.hash(a));


    String str = "123";
    Integer b = 1;
    boolean c = false;
    Object d = new Object();

    System.out.println("Objects.hash(str, b, c, c) = " + Objects.hash(str, b, c, d));

    System.out.println("hashCode = " + Arrays.asList(str, b, c, d).hashCode());

  }

  class MyObject {
    private String a;
    private Integer b;
    private boolean c;
    private Object d;

    @Override
    public int hashCode() {
      return Objects.hash(a, b, c, d);
    }
  }

}