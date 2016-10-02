package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Goblik on 31.08.2016.
 */
public class ContactModifyTest extends TestBase {
  @BeforeMethod
  public  void ensurePrecondCont(){
    app.contact().goToHomePage();
    if (app.contact().list().size()== 0) {
      app.contact().create(new ContactData().withFirstname("test1").withLastname("test11"), true);
    }
  }

  @Test
  public void testContactModify() {
    Contacts before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    app.contact().selectContact(before.size() -1);
    app.contact().editContact();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId()).withFirstname("Smith").withLastname("Gregorii");
    app.contact().modify(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));

  }
}
