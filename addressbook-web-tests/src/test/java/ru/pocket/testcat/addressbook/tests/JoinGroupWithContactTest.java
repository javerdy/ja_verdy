package ru.pocket.testcat.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.Groups;

import java.io.File;
import java.util.List;

/**
 * Created by Goblik on 12.10.2016.
 */
public class JoinGroupWithContactTest extends TestBase {


  @BeforeMethod
  public void ensurePrecondCont() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      File photo =new File("src\\test\\resources\\Utenok.jpg");
      app.contact().create(new ContactData()
              .withFirstname("namephoto")
              .withLastname("lastnamephoto")
              .withNickname("nick").withPhoto(photo), true);
    }
  }



/*
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("Cloudia")
              .withLastname("Popova")
              .withHomePhone("+866523742").withNewgroup("test1"),true);
    }
  }*/

  @Test

  public void testJoinConactWithGroups (){
    Groups groups = app.db().groups();
    File photo =new File("src\\test\\resources\\Utenok.jpg");
    ContactData newcontact = new ContactData()
            .withFirstname("namephoto")
            .withLastname("lastnamephoto")
            .withNickname("nick")
            .withPhoto(photo).inGroup(groups.iterator().next());
    app.goTo().contactPage();
    app.contact().create(newcontact,true);


  }

}
