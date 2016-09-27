package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("test2", null,null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size() , before.size()+1);

    group.setGroupid(after.stream().max((o1, o2) -> Integer.compare(o1.getGroupid(), o2.getGroupid())).get().getGroupid());
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

//первый метод
/*    int max = 0;
    for(GroupData g: after){
      if (g.getGroupid() >max) {
        max = g.getGroupid();
      }
    }*/

    // второй метод


   // int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getGroupid(), o2.getGroupid())).get().getGroupid();

/*    Comparator<? super GroupData> byId = new Comparator<GroupData>() {
      @Override
      public int compare(GroupData o1, GroupData o2) {
        return Integer.compare(o1.getGroupid(), o2.getGroupid());
      }
    };*/



/*    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getgroupCount ();
    app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    int after = app.getGroupHelper().getgroupCount();
    Assert.assertEquals(after, before + 1);*/


  }

}
