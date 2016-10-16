package ru.soap.tests;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Goblik on 16.10.2016.
 */
public class GeoTestSoap {
  @Test

  public void testMyIp() {
    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("93.80.124.25");
    assertEquals(geoIP.getCountryName(), "Russian Federation");
  }

  @Test
  public void testInvalidIp() {

    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("93.80.124.255");
    assertEquals(geoIP.getCountryCode(), "RUS");
  }
}
