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
  public void testCommits() throws IOException {
    Github github = new RtGithub("74a133d4d645cd0cb857a9a818f4ee544b5b73a9");
    RepoCommits commits = github.repos().get(new Coordinates.Simple("javerdy", "ja_verdy")).commits();
    for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
      System.out.println(new RepoCommit.Smart(commit).message());
    }
  }
}
