package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

/**
 * Created by Goblik on 31.08.2016.
 */
public class ContactModifyTest extends TestBase {

  @Test
  public void testContactModify() {

    app.getNavigationHelper().homePage();
    if (!app.getContactHelper().isThereaContact()) {
      app.getContactHelper().fillContCreationForm(new ContactData("Bear", "Smith", "Blabla","person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null,null,null, null, null, null,null),true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().editContact();
    app.getContactHelper().fillContCreationForm(new ContactData("Gregorii", "Smith", "Blabla","person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null,null,null, null, null, null,null),true);
    //app.getContactHelper().fillContactForm(new ContactData("Berta", "Lee", "Samya", "person", "Moscow, Semenovskaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", "2016", "2008", "12", "September", "5", "October", null), false);
    app.getContactHelper().updateContact();

  }


}
