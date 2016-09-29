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
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withGroupname("test2");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size() , before.size()+1);

    before.add(group);
    Comparator<? super GroupData> byId = (g1,g2)->Integer.compare(g1.getGroupid(), g2.getGroupid());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

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



/*    app.goTo().groupPage();
    int before = app.group().getgroupCount ();
    app.group().create(new GroupData("newgroup", null, null));
    int after = app.group().getgroupCount();
    Assert.assertEquals(after, before + 1);*/


  }

}
