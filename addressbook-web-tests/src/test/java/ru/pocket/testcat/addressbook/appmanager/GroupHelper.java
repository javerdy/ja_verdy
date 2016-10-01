package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


  public void create(GroupData group) {
    goToGroupPage();
    newGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCash = null;
    returnToGroupPage();
  }


/*  public boolean isThereaGroup() {
    return isElementPresent(By.name("selected[]"));

  }*/
/*
  public int getgroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }*/
/*
  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int groupid = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withGroupid(groupid).withGroupname(name));
    }
    return groups;
  }*/

  private Groups groupCash = null;

  public Groups all() {
    if (groupCash !=null){
      return new Groups(groupCash);
    }
    groupCash = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int groupid = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCash.add(new GroupData().withGroupid(groupid).withGroupname(name));
    }
    return new Groups(groupCash);
  }

  public void modify(GroupData group) {
    selectGroupById(group.getGroupid());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCash = null;
    returnToGroupPage();
  }

/*
  public void delete(int index) {
    selectGroup(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }
*/

  public void delete(GroupData group) {
    selectGroupById(group.getGroupid());
    deleteSelectedGroups();
    groupCash = null;
    returnToGroupPage();

  }

  public void selectGroupById(int groupid) {
    wd.findElement(By.cssSelector("input[value='"+groupid+"']")).click();
  }
}