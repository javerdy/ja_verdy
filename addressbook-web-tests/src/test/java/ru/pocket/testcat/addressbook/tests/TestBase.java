package ru.pocket.testcat.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.pocket.testcat.addressbook.appmanager.ApplicationManadger;

/**
 * Created by Goblik on 26.08.2016.
 */
public class TestBase {

  protected static final ApplicationManadger app = new ApplicationManadger(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
