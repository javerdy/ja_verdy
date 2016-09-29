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
      app.contact().create(new ContactData().withFirstname("test1").withLastname("test11"));
    }
  }

  @Test
  public void testContactModify() {
    List<ContactData> before = app.contact().list();
    app.contact().selectContact(before.size() -1);
    app.contact().editContact();
    ContactData contact = new ContactData()
            .withId(before.get(before.size() -1).getId()).withFirstname("test1").withFirstname("test2");
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
