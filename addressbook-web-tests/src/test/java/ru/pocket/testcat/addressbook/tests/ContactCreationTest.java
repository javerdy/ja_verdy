package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


  @Test
  public void contactCreationTest() {

    //app.goTo().homePage();
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Smith").withLastname("Gregorii");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()+1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

  }

}
