package ru.pocket.testcat.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups(){

    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withGroupname("test1").withGroupheader("header2").withGroupfooter("footer1")});
    list.add(new Object[] {new GroupData().withGroupname("test2").withGroupheader("header2").withGroupfooter("footer2")});
    list.add(new Object[] {new GroupData().withGroupname("test3").withGroupheader("header3").withGroupfooter("footer3")});
    return list.iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
   // GroupData group = new GroupData().withGroupname(name).withGroupheader(header).withGroupfooter(footer);
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().getgroupCount(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withGroupid(after.stream().mapToInt((g) ->g.getGroupid()).max().getAsInt()))));
  }


  @Test
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withGroupname("test21'");
    app.group().create(group);
    assertThat(app.group().getgroupCount (), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }
}
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
