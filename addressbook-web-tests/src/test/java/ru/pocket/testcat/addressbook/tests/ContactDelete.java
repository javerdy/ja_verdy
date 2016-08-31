package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Goblik on 31.08.2016.
 */
public class ContactDelete extends TestBase {

  @Test
  public void contactDeleteTest(){
    app.getNavigationHelper().homePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().homePage();

  }
}
