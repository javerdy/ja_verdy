package ru.pack.rest.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import ru.pack.rest.model.Issue;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Goblik on 16.10.2016.
 */
public class RestAssurHelper {
  private ApplicationManager app;

  public RestAssurHelper(ApplicationManager app) {
    this.app = app;
  }


  public Set<Issue> getIssues() throws IOException {
    String json = RestAssured.get(app.getProperty("bugify.api.url") + "issues.json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
  }

  public int createIssue(Issue newIssue) throws IOException {
    String json = RestAssured.given().parameter("subject", newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post(app.getProperty("bugify.api.url") + "issues.json").asString();

    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }
}
