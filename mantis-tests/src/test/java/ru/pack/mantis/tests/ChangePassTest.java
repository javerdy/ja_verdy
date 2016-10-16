package ru.pack.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pack.mantis.model.UserData;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created by Goblik on 16.10.2016.
 */
public class ChangePassTest extends TestBase {

  @BeforeMethod
  public void before() {
    app.mail().start();

  }

  @Test
  public void testChangePassword() throws IOException {
    UserData user = app.db().users().iterator().next();
    app.user().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    app.goTo().manageUsersPage();
    app.goTo().editUserPage(user.getId());
    app.user().resetPassword();
    String confirmationLink = app.mail().changePasswordLink(user.getEmail());
    user.setPassword(String.valueOf(System.currentTimeMillis()));
    app.user().changePassword(confirmationLink, user.getPassword());
    assertTrue(app.newSession().login(user.getName(), user.getPassword()));
  }


  @AfterMethod(alwaysRun = true)
  public void after() {
    app.mail().stop();
  }
}
