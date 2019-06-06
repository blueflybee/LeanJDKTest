package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AbstractStringBuilderTest {


  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testCapacityAndLength() {

    StringBuilder sb = new StringBuilder("abcd𠮷");
    System.out.println("sb = " + sb);

    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());
  }

  @Test
  public void testTrimToSize() {

    StringBuilder sb = new StringBuilder("abcd");
    System.out.println("sb = " + sb);

    System.out.println("before trimToSize sb.capacity() = " + sb.capacity());
    System.out.println("before trimToSize sb.length() = " + sb.length());

    sb.trimToSize();

    System.out.println("after trimToSize sb.capacity() = " + sb.capacity());
    System.out.println("after trimToSize sb.length() = " + sb.length());
  }

  @Test
  public void testSetLength() {

    StringBuilder sb = new StringBuilder("abcdef");
    System.out.println("sb = " + sb);

    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());

    sb.setLength(2);
    System.out.println("sb = " + sb);
    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());

  }


  @Test
  public void testCodePointAt() {

    StringBuilder sb = new StringBuilder("abcd𠮷");
    System.out.println("sb = " + sb);

    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());

    char charAt = sb.charAt(4);
    System.out.println("charAt 4 = " + charAt);

    int codePointAt = sb.codePointAt(4);
    System.out.println("codePointAt 4 = " + codePointAt);

  }

  @Test
  public void testCodePointCount() {

    StringBuilder sb = new StringBuilder("abcd𠮷");
    System.out.println("sb = " + sb);

    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());

    int codePointCount = sb.codePointCount(0, sb.length());
    System.out.println("codePointCount = " + codePointCount);

  }

  @Test
  public void testOffsetByCodePoints() {

    StringBuilder sb = new StringBuilder("abcd𠮷123456");
    System.out.println("sb = " + sb);

    int offsetByCodePoints = sb.offsetByCodePoints(7, -2);
    System.out.println("offsetByCodePoints = " + offsetByCodePoints);

  }

  @Test
  public void testGetChars() {

    StringBuilder sb = new StringBuilder("abcd𠮷123456");
    System.out.println("sb = " + sb);
    char[] copy = new char[20];

    sb.getChars(1, 6, copy, 5);

    System.out.println("Arrays.toString(copy) = " + Arrays.toString(copy));

  }

  @Test
  public void testAppendNull() {

    StringBuilder sb = new StringBuilder("abcd");
    System.out.println("sb = " + sb);
    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());

    String str = null;
    sb.append(str);
    sb.append(str);
    sb.append(str);
    sb.append(str);
    sb.append(str);
    System.out.println("sb = " + sb);
    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());
  }

  //end - start = 5723764
  //end - start = 3608460


  //end - start = 11824302
  //end - start = 12854869
  //end - start = 3335615
  @Test
  public void testLRMove() {

//    int q = 26;
//    int ql3 = (q << 3) + (q << 1);
//    System.out.println("q = " + q);
//    System.out.println("ql3 = " + ql3);
    long start = System.nanoTime();

    int a = 100;
    int b;
    for (int i = 0; i < 100000000; i++) {
//      a <<= 1;// 向高位移动一位，相当于乘以 2 的1次方
//      a >>= 1; // 向低位移动一位，相当于 除以 2的 1次方
      b = a * 2;
      b = a / 2;
    }

    long end = System.nanoTime();
    System.out.println("end - start = " + (end - start));

  }
  @Test
  public void testDeleteCharAt() {
    StringBuilder sb = new StringBuilder("𠮷");
    System.out.println("sb = " + sb);
    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());

    sb = sb.deleteCharAt(0);

    System.out.println("sb = " + sb);
    System.out.println("sb.capacity() = " + sb.capacity());
    System.out.println("sb.length() = " + sb.length());

  }


}