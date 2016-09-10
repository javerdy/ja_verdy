package ru.pocket.testcat.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.pocket.testcat.addressbook.appmanager.ApplicationManadger;

/**
 * Created by Goblik on 26.08.2016.
 */
public class TestBase {

  protected final ApplicationManadger app = new ApplicationManadger(BrowserType.FIREFOX);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
