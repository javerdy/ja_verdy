package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.Set;

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
    Set<ContactData> before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    app.contact().selectContact(before.size() -1);
    app.contact().editContact();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId()).withFirstname("test1").withFirstname("test2");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifyContact);
    before.add(contact);
    Assert.assertEquals(before, after);

  }


}
