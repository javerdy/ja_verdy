package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;

/**
 * Created by Goblik on 26.08.2016.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification(){
    app.gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("newgroup2", "header1", "footer1"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
