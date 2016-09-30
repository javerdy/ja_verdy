package ru.pocket.testcat.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Goblik on 26.08.2016.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withGroupname("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withGroupid(modifyGroup.getGroupid())
            .withGroupname("newgroup").withGroupheader("header1").withGroupfooter("footer1");
    app.group().modify(group);
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));
  }


}

