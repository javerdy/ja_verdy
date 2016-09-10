package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();

    if (! app.getGroupHelper().isThereaGroup()){
      app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().returnToGroupPage();
  }

}
