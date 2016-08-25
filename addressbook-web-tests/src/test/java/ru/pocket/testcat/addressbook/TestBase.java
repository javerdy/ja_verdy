package ru.pocket.testcat.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Goblik on 26.08.2016.
 */
public class TestBase {

  protected final ApplicationManadger app = new ApplicationManadger();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
