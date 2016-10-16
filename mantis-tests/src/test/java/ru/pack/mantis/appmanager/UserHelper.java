package ru.pack.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Goblik on 16.10.2016.
 */
public class UserHelper extends HelperBase {
  public UserHelper(ApplicationManadger app) {
    super(app);
  }

  public void register() {
    long now = System.currentTimeMillis();
    String user = String.format("user%s", now);
    String email = String.format("user%s@localhost.localdomain", now);
    app.registration().start(user, email);
    String confirmationLink = app.mail().confirmLink(email);
    String password = "password";
    app.registration().finish(confirmationLink, password);
  }


  public void login(String username, String password) {
    wd.get(app.getProperty("web.baseUrl") + "/login.php");
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Login']"));
  }

  public void resetPassword() {
    click(By.cssSelector("input[value='Reset Password']"));
  }

  public void changePassword(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
  }
}
