package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Goblik on 31.08.2016.
 */
public class ContactModifyTest extends TestBase {

  @Test
  public void testContactModify() {

    app.getContactHelper().goToHomePage();

    if (!app.getContactHelper().isThereaContact()) {
      app.getContactHelper().createContact(new ContactData("Bear", "Smith", "Blabla","person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null,null,null, null, null, null,null));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() -1);
    app.getContactHelper().editContact();
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"Gregorii", "Smith", "Blabla",null, null,null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);
    //app.getContactHelper().fillContCreationForm(new ContactData("Gregorii", "Smith", "Blabla", "person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null, null, null, null, null, null, null), true);
    app.getContactHelper().fillContSmallForm(contact);
    app.getContactHelper().updateContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }


}
