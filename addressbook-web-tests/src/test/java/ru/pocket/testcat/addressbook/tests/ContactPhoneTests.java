package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Goblik on 01.10.2016.
 */
public class ContactPhoneTests extends TestBase {

  @BeforeMethod

  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().allmerge().size() == 0) {
      app.contact().createwithoutdrop(new ContactData()
              .withFirstname("test1")
              .withLastname("test2")
              .withHomePhone("+1111")
              .withWork("22-22-2")
              .withAddress("address")
              .withEmail(" email@")
              .withEmail2("(hdgdrx@)")
              .withEmail3("trbfjd-fss@").withAddress("Moscow").withAddress2("Zheleznodorozhnaya"));

    }}



  @Test
  public void testAllPhones() {
    app.goTo().homePage();
    ContactData contactData = app.contact().allmerge().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contactData);

    assertThat(contactData.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contactData.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    assertThat(contactData.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));

  }

  private String mergeEmails(ContactData contemail) {
    return  Arrays.asList(contemail.getEmail(),contemail.getEmail2(), contemail.getEmail3())
            .stream().filter((s) -> ! s.equals("")).map(ContactPhoneTests::cleanmail)
            .collect(Collectors.joining("\n"));
  }


    public static String cleanmail (String mail){
      return mail.replaceAll("\\s","").replaceAll(" [-()]","");
    }


  private String mergePhones(ContactData contactmerge) {

    return  Arrays.asList(contactmerge.getHomePhone(),contactmerge.getWorkPhone(), contactmerge.getMobile())
            .stream().filter((s) -> ! s.equals("")).map(ContactPhoneTests::clean)
            .collect(Collectors.joining("\n"));

  }

  public static String clean (String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }

  /*  @Test
  public void testPhones() {
    app.goTo().homePage();
    ContactData contactData = app.contact().alllistSplit().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contactData);

    assertThat(contactData.getAllPhones(), equalTo(contactInfoFromEditForm.getAllPhones()));
    assertThat(contactData.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contactData.getMobile(), equalTo(cleaned(contactInfoFromEditForm.getMobile())));
    assertThat(contactData.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
//    assertThat(contactData.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
 //   assertThat(contactData.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
 //   assertThat(contactData.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
 //   assertThat(contactData.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));
  }
  public String cleaned (String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }*/

}
