package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CharacterTest {


  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testHighSurrogate() {
    int ji = 0x20BB7;
    System.out.println("Character.MIN_HIGH_SURROGATE = " + Character.MIN_HIGH_SURROGATE);
    char high = (char) ((ji >>> 10) - (Character.MIN_SUPPLEMENTARY_CODE_POINT >>> 10) + Character.MIN_HIGH_SURROGATE);
    System.out.println("high = " + high);
    System.out.println("Integer.toHexString(high) = " + Integer.toHexString(high));

    char low = (char) (((ji) & 0x3ff) + Character.MIN_LOW_SURROGATE);
    System.out.println("low = " + low);
    System.out.println("Integer.toHexString(low) = " + Integer.toHexString(low));

    int codePoint = Character.toCodePoint(high, low);
    System.out.println("Integer.toHexString(codePoint) = " + Integer.toHexString(codePoint));
  }


}