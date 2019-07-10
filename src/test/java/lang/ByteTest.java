package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ByteTest {


  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testToString() {
    byte b = 123;
    String result = Byte.toString(b);
    System.out.println("result = " + result);

    System.out.println("Byte.SIZE = " + Byte.BYTES);
  }

  @Test
  public void testParseByte() {
    byte b = 123;
    byte result = Byte.parseByte("1a", 16);
    System.out.println("result = " + result);

  }

  @Test
  public void testDecode() {
    byte result = Byte.decode("11");
    System.out.println("result = " + result);

  }

  @Test
  public void testValueOf() {
    byte result = Byte.valueOf((byte) 0x11);
    System.out.println("result = " + result);

  }

}