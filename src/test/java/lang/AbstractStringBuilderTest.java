package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

}