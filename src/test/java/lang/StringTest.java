package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StringTest {



  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testCreateStringInstance() {
    //public String(char value[], int offset, int count)
    System.out.println("++++++++++++++++++++++string from char array:");
    char[] from = new char[]{64, 65, 66, 126, 19, 28, 16};
    String str = new String(from, 0, 4);
    System.out.println("str = " + str);

    //public String(int[] codePoints, int offset, int count)
    System.out.println("++++++++++++++++++++++string from codePoints:");
//    \u4f60\u597d
    int[] codePoints = new int[]{0x20BB7, 0x4f60, 0x597d, 0x0041};
    str = new String(codePoints, 0, 4);
    System.out.println("str = " + str);

    char[] chars = str.toCharArray();
    for (char aChar : chars) {
      System.out.println("aChar = " + aChar);
    }
    System.out.println("chars.length = " + chars.length);


    int high = str.charAt(0);
    System.out.println("high = " + high);
    int low = str.charAt(1);
    System.out.println("low = " + low);


    String highHex = Integer.toHexString(high);
    System.out.println("UTF-16 highHex = " + highHex);

    String lowHex = Integer.toHexString(low);
    System.out.println("UTF-16 lowHex = " + lowHex);


//    double h = Math.floor((codePoints[0] - 0x10000) / 0x400) + 0xD800;
//
//    int l = (codePoints[0] - 0x10000) % 0x400 + 0xDC00;
//
//    System.out.println("h = " + h);
//    System.out.println("l = " + l);


  }


}