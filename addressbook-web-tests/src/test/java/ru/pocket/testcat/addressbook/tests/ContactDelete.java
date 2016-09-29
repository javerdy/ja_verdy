package ru.pocket.testcat.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by Goblik on 31.08.2016.
 */
public class ContactDelete extends TestBase {

  @BeforeMethod
  public void ensurePrecondCont() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Bear", "Smith", "Blabla", "person", "Moscow, Zheleznodorozhnaya", "111111-11", "968546789", "44444444", "888888", "m.osipo.a@mail.ru", "www.yandex.ru", "Moscow2", "my notes", null, null, null, null, null, null, null));
    }
  }

  @Test
  public void contactDeleteTest() {
    List<ContactData> before = app.contact().list();
    int index =before.size() - 1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}

