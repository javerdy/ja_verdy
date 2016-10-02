package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {


/*  @Test

  public void contactCreationTest() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Smith").withLastname("Gregorii");
    app.contact().create(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }*/

/*  @Test
  public void contactBadCreationTest() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Smith").withLastname("Gregorii");
    app.contact().create(contact);
    assertThat(app.contact().getContactCount(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }*/

  @Test

  public void testSimoleContactCreation (){
    app.goTo().contactPage();
    File photo =new File("src\\test\\resources\\Utenok.jpg");
    app.contact().create(new ContactData().withFirstname("namephoto")
            .withLastname("lastnamephoto").withNickname("nick")
            .withPhoto(photo),true);

  }

/*  @Test
  public  void testcurrentDir (){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo =new File("src\\test\\resources\\Utenok.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }*/

}
