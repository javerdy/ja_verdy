package ru.pack.rest.tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import ru.pack.rest.appmanager.ApplicationManager;

/**
 * Created by Goblik on 16.10.2016.
 */
public class TestBase {

  protected static final ApplicationManager app =
          new ApplicationManager();

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  public boolean isIssueOpen(int issueId) throws IOException {
    return app.rest().isIssueOpen(issueId);
  }

  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }
}
