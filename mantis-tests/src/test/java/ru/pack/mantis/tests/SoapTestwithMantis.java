package ru.pack.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.pack.mantis.model.Issue;
import ru.pack.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Goblik on 16.10.2016.
 */
public class SoapTestwithMantis extends TestBase{

  @Test
  public void testGetProjects() throws RemoteException, ServiceException, MalformedURLException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    projects.stream().forEach(project -> System.out.println(project.getName()));
  }

  @Test
  public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
    Set<Project> projects = app.soap().getProjects();
    for (int i = 2; i < 10; i++) {
      Issue issue = new Issue()
              .withSummary("Test issue").withDescription("Test issue description").withProject(projects.iterator().next());
      Issue created = app.soap().addIssue(issue);
      Assert.assertEquals(issue.getSummary(), created.getSummary());
    }
  }

  @DataProvider
  public Iterator<Object[]> issueIdsModel() throws RemoteException, ServiceException, MalformedURLException {
    return app.soap().getIssueList().stream().map((issue) -> new Object[]{issue}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "issueIdsModel")
  public void testReadyForCheckIssues(Issue issue) throws RemoteException, ServiceException, MalformedURLException {
    skipIfNotFixed(issue.getId());
    System.out.println(String.format("Issue is with id:%s could be tested", issue.getId()));
  }
}
