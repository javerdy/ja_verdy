package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

/**
 * Created by Goblik on 31.08.2016.
 */
public class ContactDelete extends TestBase {

  @Test
  public void contactDeleteTest() {
    app.getNavigationHelper().addContactPage();
    if (!app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact(new ContactData("Jon", "Smith", "Blabla", "person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", "1995","2005","12", "September", "5", "October","newgroup2"),true);
      //app.getContactHelper().createContact(new ContactData("Jon", "Smith", "Blabla", "person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", "1995","2005","12", "September", "5", "October","newgroup2"),true)));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getNavigationHelper().homePage();

  }
}
