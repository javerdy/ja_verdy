package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Goblik on 09.10.2016.
 */
public class GroupDBDeletion extends TestBase {

   @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().groupPage();
      if (app.db().groups().size() == 0) {
        app.group().create(new GroupData()
                .withGroupname("newgroup"));
      }
    }
    @Test
    public void testGroupDeletion () {
      Groups before = app.db().groups();
      app.goTo().groupPage();
      GroupData deletedGroup = before.iterator().next();
      app.group().delete(deletedGroup);
      assertThat(app.group().getgroupCount(), equalTo(before.size() - 1));
      Groups after = app.db().groups();
      assertThat(after, equalTo(before.without(deletedGroup)));
      verifyGroupListInUI();
    }
}