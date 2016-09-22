package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;
import java.util.List;

public class GroupDeletionTest extends TestBase {


  @Test
  public void testGroupDeletion() {

    app.getNavigationHelper().gotoGroupPage();

    if (!app.getGroupHelper().isThereaGroup()) {
      app.getGroupHelper().createGroup(new GroupData("newgroup", null, null));
    }

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after, before.size() - 1);

    before.remove(before.size() - 1);
      Assert.assertEquals(before, after);

    }

  }
