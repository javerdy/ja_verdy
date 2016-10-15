package ru.pack.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.pack.mantis.appmanager.ApplicationManadger;


/**
 * Created by Goblik on 26.08.2016.
 */
public class TestBase {

  protected static final ApplicationManadger app
          = new ApplicationManadger(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

}