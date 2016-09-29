package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void contactCreationTest() {

    //app.goTo().homePage();
    app.goTo().contactPage();
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData("Smith", "Gregorii", null,null,null,null, null, null, null,null,null,null,null,null,null,null,null,null,null,null);
    //app.contact().fillContactForm(new ContactData("Jon", "Smith", "Blabla", "person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", "1995","2005","12", "September", "5", "October","newgroup2"),true);
    //app.contact().fillContCreationForm(new ContactData("Bear", "Smith", "Blabla","person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null,null,null, null, null, null,null),true);
    //app.contact().create(new ContactData("Bear", "Smith", "Blabla","person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null,null,null, null, null, null,null));
    app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size()+1);

/*    int max =0;
    for(ContactData g: after){
      if (g.getId() >max){
        max = g.getId();
      }
    }*/
    //contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add((contact));
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
