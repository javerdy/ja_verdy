package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

/**
 * Created by Goblik on 31.08.2016.
 */
public class ContactDelete extends TestBase {

  @Test
  public void contactDeleteTest() {

    app.getNavigationHelper().homePage();
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact(new ContactData("Bear", "Smith", "Blabla","person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null,null,null, null, null, null,null));
    }

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertDel();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before -1);
  }
}
