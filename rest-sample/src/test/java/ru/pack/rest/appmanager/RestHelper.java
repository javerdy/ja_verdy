package ru.pack.rest.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import ru.pack.rest.model.Issue;

import java.io.IOException;
import java.util.Set;

/**
 * Created by Goblik on 16.10.2016.
 */
public class RestHelper {
  private ApplicationManager app;

  public RestHelper(ApplicationManager app) {
    this.app = app;
  }

  public Set<Issue> getIssues() throws IOException {
    String json = getExecutor().execute(Request.Get(app.getProperty("bugify.api.url") + "issues.json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
  }

  private Executor getExecutor() {
    return Executor.newInstance().auth("LSGjeU4yP1X493ud1hNniA==", "");
  }

  public int createIssue(Issue newIssue) throws IOException {
    String json = getExecutor().execute(Request.Post(app.getProperty("bugify.api.url") + "issues.json")
            .bodyForm(new BasicNameValuePair("subject", newIssue.getSubject()),
                    new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }

  public boolean isIssueOpen(int id) throws IOException {
    String json = getExecutor().execute(Request.Get(app.getProperty("bugify.api.url") + "issues/" + id + ".json"))
            .returnContent().asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    Set<Issue> issueSet = new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {
    }.getType());
    return issueSet.iterator().next().getState() == 0 ||
            issueSet.iterator().next().getState() == 1;
  }

}
