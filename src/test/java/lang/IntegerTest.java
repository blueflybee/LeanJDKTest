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

}