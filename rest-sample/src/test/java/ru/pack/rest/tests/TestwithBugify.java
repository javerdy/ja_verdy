package ru.pack.rest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Goblik on 16.10.2016.
 */
public class TestwithBugify extends TestBase {
  public Iterator<Object[]> issueIdsModel() throws IOException {
    return app.rest().getIssues().stream().map((issue) -> new Object[]{issue}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]> issueIdGenModel() throws IOException {
    List<Issue> issues = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      issues.add(new Issue().withId(i));
    }
    return issues.stream().map((issue) -> new Object[]{issue}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "issueIdGenModel")
  public void testReadyForCheckIssues(Issue issue) throws IOException {
    skipIfNotFixed(issue.getId());
    System.out.println(String.format("Issue is with id:%s could be tested", issue.getId()));
  }
}
