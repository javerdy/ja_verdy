package ru.pocket.testcat.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withGroupname("test2");
    app.group().create(group);
    assertThat(app.group().getgroupCount(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before
            .withAdded(group.withGroupid(after.stream().mapToInt((g) -> g.getGroupid()).max().getAsInt()))));
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
