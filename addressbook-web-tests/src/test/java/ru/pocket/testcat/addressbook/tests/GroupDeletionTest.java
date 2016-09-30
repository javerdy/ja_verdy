package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

import static org.hamcrest.CoreMatchers.equalTo;


public class GroupDeletionTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withGroupname("test1"));
    }

  }

  @Test
  public void testGroupDeletion() {
    Groups before = app.group().all();
    GroupData deleteGroup = before.iterator().next();
    app.group().delete(deleteGroup);
    Groups after = app.group().all();
    assertEquals(after, before.size() - 1);
    assertThat(after, equalTo(before.without(deleteGroup)));


  }


}
