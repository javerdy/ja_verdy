package ru.pack.mantis.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by Goblik on 15.10.2016.
 */
public class RegistrationHelper {
  private final ApplicationManadger app;
  private WebDriver wd;

  public RegistrationHelper(ApplicationManadger app) {
    this.app = app;
    wd=app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
  }
}
