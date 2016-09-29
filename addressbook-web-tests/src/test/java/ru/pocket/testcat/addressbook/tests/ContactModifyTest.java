package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Goblik on 31.08.2016.
 */
public class ContactModifyTest extends TestBase {
  @BeforeMethod
  public  void ensurePrecondCont(){
    app.contact().goToHomePage();
    if (app.contact().list().size()== 0) {
      app.contact().create(new ContactData("Gregorii","Smith",null,null, null,null, null, null, null, null, null, null, null, null, null, null, null, null, null,null));
    }
  }

  @Test
  public void testContactModify() {
    List<ContactData> before = app.contact().list();
    app.contact().selectContact(before.size() -1);
    app.contact().editContact();
    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"Gregorii", "Smith", null,null, null,null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);
    //app.contact().fillContCreationForm(new ContactData("Gregorii", "Smith", "Blabla", "person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null, null, null, null, null, null, null), true);
    app.contact().fillContSmallForm(contact);
    app.contact().updateContact();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
