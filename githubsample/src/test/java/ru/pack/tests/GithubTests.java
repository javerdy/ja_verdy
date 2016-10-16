package ru.pack.tests;
import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Goblik on 16.10.2016.
 */
public class GithubTests {

  @Test
  public void testCommitBarantsev() throws IOException {
    Github github = new RtGithub("e1074a3eeb968f536fae506bfe0921f8160f7fc1");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("javerdy", "ja_verdy")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }

  @Test
  public void testCommitGmail() throws IOException {
    Github github = new RtGithub("e1074a3eeb968f536fae506bfe0921f8160f7fc1");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("javerdy", "gettingtest")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }

}
