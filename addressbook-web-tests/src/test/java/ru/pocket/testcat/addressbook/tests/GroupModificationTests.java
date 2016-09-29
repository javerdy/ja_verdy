package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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

  @BeforeMethod
  public  void ensurePreconditions(){
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    }
  }
  @Test
  public void testGroupModification() {
    //int before = app.getGroupHelper().getgroupCount ();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getGroupid(),"newgroup", "header1", "footer1");
    app.getGroupHelper().modifyGroup(index, group);
    //int after = app.getGroupHelper().getgroupCount ();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getGroupid(), g2.getGroupid());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    }



}

