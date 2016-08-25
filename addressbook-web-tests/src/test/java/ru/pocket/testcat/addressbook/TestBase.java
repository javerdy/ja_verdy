package ru.pocket.testcat.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by Goblik on 26.08.2016.
 */
public class TestBase extends ApplicationManadger {

  @BeforeMethod
  public void setUp() throws Exception {
    init();
  }

  @AfterMethod
  public void tearDown() {
    stop();
  }

}
