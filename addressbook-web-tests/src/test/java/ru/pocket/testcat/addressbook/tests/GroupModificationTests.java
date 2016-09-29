package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Goblik on 26.08.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public  void ensurePreconditions(){
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData("newgroup", null, null));
    }
  }
  @Test
  public void testGroupModification() {
    //int before = app.group().getgroupCount ();
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getGroupid(),"newgroup", "header1", "footer1");
    app.group().modify(index, group);
    //int after = app.group().getgroupCount ();
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getGroupid(), g2.getGroupid());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    }



}

