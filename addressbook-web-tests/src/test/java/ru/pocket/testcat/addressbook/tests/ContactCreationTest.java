package ru.pocket.testcat.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

 // Logger logger = LoggerFactory.getLogger(ContactCreationTest.class);


  @DataProvider

  public Iterator<Object[]> readyContactsFromXML() throws IOException {

    try (BufferedReader reader = new BufferedReader(new FileReader(
            new File("src/test/resources/contact.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }


  @DataProvider
  public Iterator<Object[]> readyContactsFromJSON() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(
            new File("src/test/resources/contact.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();
    }
  }


/*  @Test(dataProvider = "readyContactsFromJSON")
  public void testContJsonCreationfoto(ContactData contact) {
    app.contact().goToHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src\\test\\resources\\Utenok.jpg");
    ContactData contact = new ContactData()
            .withFirstname("firstname1").withLastname("lastname2").withHomePhone("+7900565")
            .withHomePhone("1234567").withNewgroup("test1").withPhoto(photo);
    //app.goTo().homePage();
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().getContactCount(),equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }*/


  @Test(dataProvider = "readyContactsFromJSON")
  public void testContJsonCreation(ContactData contact) {
 //   logger.info("Start test ContactCreation");
    app.contact().goToHomePage();
    Contacts before = app.contact().all();
    app.contact().createwithoutdrop(contact);
    assertThat(app.contact().getContactCount(),equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
 //   logger.info("Stop test ContactCreation");

  }


/*
  @Test(enabled = true)
  public void testContactCreation() {
    app.contact().goToHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src\\test\\resources\\Utenok.jpg");
    ContactData contact = new ContactData()
            .withFirstname("firstname1").withLastname("lastname2").withHomePhone("+7900565")
            .withHomePhone("1234567").withNewgroup("test1").withPhoto(photo);
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().getContactCount(),equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
  }*/

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
