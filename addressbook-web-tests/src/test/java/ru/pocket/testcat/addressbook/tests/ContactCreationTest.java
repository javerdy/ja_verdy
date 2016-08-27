package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {


  @Test
  public void contactCreationTest() {
    app.getContactHelper().addContactPage();
    app.getContactHelper().fillContactForm(new ContactData("Marina", "Verdy", "verdyanna", "person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", "1995","2005"));
    app.getContactHelper().pressEnter();
    app.getContactHelper().homePage();
  }

}
