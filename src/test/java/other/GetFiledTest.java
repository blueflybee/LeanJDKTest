package test.java.other;

public class GetFiledTest {

  char[] arr = new char[100];

  public static void main(String[] args) {
    GetFiledTest t = new GetFiledTest();
    t.test();
  }

  public void test() {
    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(arr[2]);
  }

  public void test1() {
    char[] val = this.arr;
    System.out.println(val[0]);
    System.out.println(val[1]);
    System.out.println(val[2]);
  }


}