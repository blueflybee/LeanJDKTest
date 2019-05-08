package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Float.NaN;

public class FloatTest {


  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testFloatToRawIntBits() {
    int i = Float.floatToRawIntBits(20.59375f);
    System.out.println("i = " + i);
    String s = Integer.toHexString(i);
    System.out.println("s = " + s);

    i = Float.floatToIntBits(20.59375f);
    System.out.println("i = " + i);
    s = Integer.toHexString(i);
    System.out.println("s = " + s);
  }

}