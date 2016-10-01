package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Goblik on 01.10.2016.
 */
public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().createwithoutdrop(new ContactData()
              .withFirstname("test1")
              .withLastname("test2")
              .withHomePhone("1111")
              .withMobile("2222")
              .withWork("3333")
              .withAddress("address")
              .withEmail("email")
              .withEmail2("email2")
              .withEmail3("email3"));

    }

  }
  @Test
  public  void testContPhones(){
    app.goTo().homePage();
    ContactData contactData =app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm =app.contact().infoFromEditForm(contactData);

    assertThat(contactData.getHomePhone(), equalTo(contactInfoFromEditForm.getHomePhone()));
    assertThat(contactData.getMobile(), equalTo(contactInfoFromEditForm.getMobile()));
    assertThat(contactData.getWorkPhone(), equalTo(contactInfoFromEditForm.getWorkPhone()));
  }
}
