package ru.pocket.testcat.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.gotoGroupPage();
    app.newGroupCreation();
    app.fillGroupForm(new GroupData("newgroup", "header1", "footer1"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
