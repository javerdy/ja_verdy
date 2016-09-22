package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Goblik on 26.08.2016.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification() {

    app.getNavigationHelper().gotoGroupPage();

    if (!app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    }
    //int before = app.getGroupHelper().getgroupCount ();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("newgroup2", "header1", "footer1"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    //int after = app.getGroupHelper().getgroupCount ();
    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size()-1);


    }

  }

