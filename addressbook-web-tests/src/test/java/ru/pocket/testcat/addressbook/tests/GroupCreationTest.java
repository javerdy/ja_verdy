package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test1", null,null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size() , before.size()+1);


    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));


/*    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getgroupCount ();
    app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    int after = app.getGroupHelper().getgroupCount();
    Assert.assertEquals(after, before + 1);*/


  }

}
