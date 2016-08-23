package ru.pocket.catmain;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Goblik on 23.08.2016.
 */
public class SquareTests {


  @Test
  public void testArea(){

    Square nsc = new Square(5);
    Assert.assertEquals(nsc.area(),25.0);
  }

}
