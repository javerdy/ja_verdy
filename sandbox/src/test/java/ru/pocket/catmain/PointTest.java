package ru.pocket.catmain;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Goblik on 23.08.2016.
 */
public class PointTest {


  @Test
  public void testArea() {

    Point p1 = new Point(7, 8);

    Point p2 = new Point(3, 2);

    Assert.assertEquals(p1.distance(p2),7.211102550927978);
    Assert.assertEquals(Math.round(p1.distance(p2)),7);
    Assert.assertEquals(p1.distance(p2), Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)));
    Assert.assertEquals(Math.round(Math.pow(p1.distance(p2),2)),Math.round(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)));
    Assert.assertNotEquals(p1.distance(p2),Math.sqrt(Math.pow((p2.x - p1.x), 2) - Math.pow((p2.y - p1.y), 2)));
  }


  @Test
  public void testArea1() {

    Point p1 = new Point(0, 0);

    Point p2 = new Point(0, 0);

    Assert.assertEquals(p1.distance(p2), 0.0);
    Assert.assertEquals(Math.round(p1.distance(p2)),0);
    Assert.assertEquals(p1.distance(p2), Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)));
    Assert.assertEquals(Math.round(Math.pow(p1.distance(p2),2)),Math.round(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)));
    //Assert.assertNotEquals(p1.distance(p2),Math.sqrt(Math.pow((p2.x - p1.x), 2) - Math.pow((p2.y - p1.y), 2)));

  }

  @Test
  public void testArea2() {

    Point p1 = new Point(-1, 1);

    Point p2 = new Point(1, 1);

    Assert.assertEquals(p1.distance(p2), 2.0);
    Assert.assertEquals(Math.round(p1.distance(p2)),2);
    Assert.assertEquals(p1.distance(p2), Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)));
    //Assert.assertEquals(Math.round(Math.pow(p1.distance(p2),2)),Math.round(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2)));

  }


}