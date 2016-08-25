package ru.pocket.testcat.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    gotoGroupPage();
    newGroupCreation();
    fillGroupForm(new GroupData("newgroup", "header1", "footer1"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
