package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.contact().goToHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src\\test\\resources\\Utenok.jpg");
    ContactData contact = new ContactData()
            .withFirstname("firstname1").withLastname("lastname2").withHomePhone("+7900565")
            .withHomePhone("1234567").withNewgroup("test1").withPhoto(photo);
    app.goTo().homePage();
    app.contact().create(contact, true);
    assertThat(app.contact().getContactCount(),equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
  }

/*  @Test

  public void testSimoleContactCreation (){
    app.goTo().contactPage();
    File photo =new File("src\\test\\resources\\Utenok.jpg");
    app.contact().create(new ContactData().withFirstname("namephoto")
            .withLastname("lastnamephoto").withNickname("nick")
            .withPhoto(photo),true);

  }*/

/*  @Test
  public  void testcurrentDir (){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo =new File("src\\test\\resources\\Utenok.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }*/

}
