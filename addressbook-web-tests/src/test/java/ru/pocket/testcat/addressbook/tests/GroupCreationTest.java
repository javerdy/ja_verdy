package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

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
