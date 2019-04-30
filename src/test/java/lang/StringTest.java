package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

  @Test
  public void testCompareTo() {
    String str1 = "abc";
    String str2 = "IloveU";
    System.out.println(str1.compareTo(str2));
  }

  @Test
  public void testMatches() {
    String str1 = "aaaaaaaaab";
    System.out.println("matches = " + str1.matches("a*b"));
  }

  @Test
  public void testReplaceFirst() {
    String str1 = "aaaaaaaaabcdefhsdger";
    System.out.println("result = " + str1.replaceFirst("a*b", "哈哈"));
    System.out.println("result = " + str1.replaceFirst("a*b", Matcher.quoteReplacement("哈哈\\")));
    System.out.println("result = " + str1.replaceFirst("a*b", Matcher.quoteReplacement("哈哈$")));
    System.out.println("result = " + str1.replaceFirst("a*b", Matcher.quoteReplacement("哈$$$哈")));
    System.out.println("result = " + str1.replaceFirst("a*b", Matcher.quoteReplacement("$\\$哈\\\\\\$$$哈\\\\\\")));

  }

  @Test
  public void testSplit() {
    String str = "boo:and:foo:my:w:::can::";
    System.out.println("split 4 = " + Arrays.toString(str.split(":", 4)));
    System.out.println("split 10 = " + Arrays.toString(str.split(":", 10)));
    System.out.println("split -2 = " + Arrays.toString(str.split(":", -2)));
    System.out.println("split 0 = " + Arrays.toString(str.split(":", 0)));

  }

  @Test
  public void testJoin() {
    String delimiter = "-";
    String join = String.join(delimiter, "Java", null, "is", null, "cool");
    System.out.println("join = " + join);

    List<String> strings = new LinkedList<>();
    strings.add("Java");
    strings.add("is");
    strings.add("cool");
    String message = String.join(" ", strings);
    System.out.println("message = " + message);

    HashSet<String> strings1 = new HashSet<>();
    strings1.add("Java");
    strings1.add("is");
    strings1.add("cool");
    String join1 = String.join("-", strings1);
    System.out.println("join1 = " + join1);
  }


  @Test
  public void testIntern() {

    String s1 = "HelloWorld";//放入常量池
    String s2 = new String("HelloWorld");//放入堆
    String s3 = "Hello";//放入常量池
    String s4 = "World";//放入常量池
    String s5 = "Hello" + "World";//拼接后，在常量池寻找HelloWorld返回
    String s6 = s3 + s4;//放入堆

    System.out.println(s1 == s2);//false
    System.out.println(s1 == s5);//true
    System.out.println(s1 == s6);//false
    System.out.println(s1 == s6.intern());//true
    System.out.println(s2 == s2.intern());//false

  }
}