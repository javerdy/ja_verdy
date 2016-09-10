package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    app.getNavigationHelper().returnToGroupPage();

  }

}
