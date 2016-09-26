package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
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

    GroupData group = new GroupData(before.get(before.size() - 1).getGroupid(),"newgroup2", "header1", "footer1");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    //int after = app.getGroupHelper().getgroupCount ();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());


    before.remove(before.size()-1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getGroupid(), g2.getGroupid());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    }

  }

