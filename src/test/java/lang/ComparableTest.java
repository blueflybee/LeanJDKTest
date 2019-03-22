package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ComparableTest {


  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSortable() {

    try {
//    ArrayList<Foo> objects = new ArrayList<>();
//    objects.add(new Foo());
//    objects.add(new Foo());
//    objects.add(new Foo());
//    objects.add(new Foo());

      Foo[] foos = new Foo[]{new Foo(), new Foo(), new Foo()};

//    Collections.sort(objects);

      Arrays.sort(foos);

      fail("should throw an exception");

    } catch (ClassCastException e) {
      assertTrue(true);
      e.printStackTrace();
    }

  }


  class Foo{
//
//    @Override
//    public int compareTo(Foo o) {
//      return 0;
//    }
  }
}