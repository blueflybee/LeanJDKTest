package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntegerTest {


  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testNumberOfLeadingZeros() {
    int zeros = Integer.numberOfLeadingZeros(7);
    System.out.println("zeros = " + zeros);
  }


  @Test
  public void testSignum() {
    // returns 1 as int value is greater than 0
    System.out.println(Integer.signum(50));

    // returns -1 as int value is less than 0
    System.out.println(Integer.signum(-50));

    // returns 0 as int value is equal to 0
    System.out.println(Integer.signum(0));
  }

  @Test
  public void testRotateRight() {
    System.out.println(Integer.rotateRight(12, 2));
  }

  @Test
  public void testRotateLeft() {
    System.out.println(Integer.rotateLeft(3, 2));
  }

  @Test
  public void testBitCount() {
    System.out.println(Integer.bitCount(13));
  }

  @Test
  public void testToUnsignedString() {
    System.out.println(Integer.toString(-2019));
    System.out.println(Integer.toUnsignedString(-0, 2));
  }

  @Test
  public void testToUnsignedLong() {
    System.out.println(Integer.toUnsignedLong(-1));
  }

  @Test
  public void testToHexString() {
    System.out.println(Integer.toHexString(-2));
  }
}