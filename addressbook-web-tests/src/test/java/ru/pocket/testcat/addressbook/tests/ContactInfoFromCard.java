package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by Goblik on 02.10.2016.
 */
public class ContactInfoFromCard extends TestBase {
  @BeforeMethod

  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().allmerge().size() == 0) {
      app.contact().createwithoutdrop(new ContactData()
              .withFirstname("test1")
              .withLastname("test2")
              .withHomePhone("1111")
              .withWork("22-22-2")
              .withAddress("address")
              .withEmail("email@ya.ru")
              .withEmail2("hdgdrx@)rambler.ru")
              .withEmail3("trbfjdfss@gmail.com"));

    }
  }


  @Test
  public void testAllPhones() {
    app.goTo().homePage();
    ContactData contactData = app.contact().allmerge().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contactData);
    String infoCardForm = app.contact().getConfromcardForm(contactData);

    assertThat(contactData.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contactData.getAllEmails(), equalTo(mergeEmailes(contactInfoFromEditForm)));
    assertThat(contactData.getAddress(), equalTo(cleanedTabs(contactInfoFromEditForm.getAddress())));

    assertThat(mergeData(contactInfoFromEditForm), equalTo(infoCardForm));

  }
  private String mergeData(ContactData contact) {
    String names = Arrays.asList(contact.getFirstname() + " ",contact.getLastname()).stream()
            .filter((s) -> !s.equals("")).collect(Collectors.joining(""));

    String address = Arrays.asList(contact.getAddress()).stream()
            .filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));

    String homePhone = "H: " + contact.getHomePhone();
    String mobilePhone = "M: " + contact.getMobile();
    String workPhone = "W: " + contact.getWorkPhone();
    String allPhones = Arrays.asList(homePhone, mobilePhone, workPhone).stream().
            filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));

    String email = contact.getEmail() + " (" + contact.getEmail()
            .replaceAll("^([a-z0-9_\\.-]+)@", "www.") + ")";
    String email2 = contact.getEmail2() + " (" + contact.getEmail2()
            .replaceAll("^([a-z0-9_\\.-]+)@", "www.") + ")";
    String email3 = contact.getEmail3() + " (" + contact.getEmail3()
            .replaceAll("^([a-z0-9_\\.-]+)@", "www.") + ")";

    String allEmails = Arrays.asList(email, email2, email3).stream().
            filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));

    String allData = names + "\n" + address + "\n" + "\n" + allPhones + "\n" + "\n" + allEmails;

    return allData;
  }

  private String mergeEmailes(ContactData contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3()).stream()
            .filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(),contact.getMobile(),contact.getWorkPhone())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactInfoFromCard::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s","").replaceAll("[-)+(\\.]","");
  }

  public static String cleanedNull(String data) {
    return data.replaceAll("null","");
  }

  public static String cleanedTabs(String data) {
    //на всякий случай чистим переносы строк и пробелы на конце в данных (могут быть в адресе)
    return data.replaceAll("\\s$","");
  }
}
