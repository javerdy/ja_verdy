package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testGroupDeletion() {

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getgroupCount ();

    if (!app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    int after = app.getGroupHelper().getgroupCount ();
    Assert.assertEquals(after, before - 1);

  }

}
