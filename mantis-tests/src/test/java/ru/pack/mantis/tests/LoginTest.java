package ru.pack.mantis.tests;

import org.testng.annotations.Test;
import ru.pack.mantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Goblik on 15.10.2016.
 */
public class LoginTest extends TestBase{
  @Test
  public void testLogin() throws IOException {
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator", "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }
}
