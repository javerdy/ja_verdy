package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.pocket.testcat.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goblik on 26.08.2016.
 */
public class GroupHelper extends BaseHelper {


  public GroupHelper(WebDriver wd) {
    super(wd);
  }


  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getGroupname());
    type(By.name("group_header"), groupData.getGroupheader());
    type(By.name("group_footer"), groupData.getGroupfooter());
  }

  public void newGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void goToGroupPage() {
    wd.get("http://localhost/addressbook/group.php");
  }


  public void createGroup(GroupData group) {
    goToGroupPage();
    newGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }


  public boolean isThereaGroup() {
    return isElementPresent(By.name("selected[]"));

  }

  public int getgroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int groupid = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(groupid,name, null, null);
      groups.add(group);
    }
    return groups;
  }
}