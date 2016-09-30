package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase {


  @Test
  public void contactCreationTest() {

    //app.goTo().homePage();
    app.goTo().contactPage();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Smith").withLastname("Gregorii");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()+1);
    contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
    before.add((contact));
    Assert.assertEquals(before, after);
/*    int max =0;
    for(ContactData g: after){
      if (g.getId() >max){
        max = g.getId();
      }
    }*/
    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

  }

}
