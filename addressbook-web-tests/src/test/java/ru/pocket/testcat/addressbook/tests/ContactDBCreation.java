package ru.pocket.testcat.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
/**
 * Created by Goblik on 09.10.2016.
 */
public class ContactDBCreation extends TestBase{

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
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());
      return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider = "readyContactsFromJSON")
  public void testContJsonCreation(ContactData contact) {
    Contacts before = app.db().contacts();
    app.goTo().homePage();
    app.contact().createwithoutdrop(contact);
    assertThat(app.contact().getContactCount(),equalTo(before.size() + 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
    verifyContactListInUI();
  }

}
