package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size() , before.size()+1);

/*    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getgroupCount ();
    app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    int after = app.getGroupHelper().getgroupCount();
    Assert.assertEquals(after, before + 1);*/


  }

}
