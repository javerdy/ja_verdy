package ru.pocket.testcat.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.Contacts;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Goblik on 12.10.2016.
 */
public class JoinGroupWithContactTest extends TestBase {


  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData()
              .withGroupname("group1")
              .withGroupheader("groupheader1")
              .withGroupfooter("groupfooter1"));
    }
    if (app.db().contacts().size() == 0) {
      app.goTo().homePage();
      app.contact().create(new ContactData()
              .withFirstname("contactname")
              .withLastname("lastname")
              .withWork("8674646"), true);
    }

  }

  @Test

/*  public void testJoinConactWithGroups() {
    Groups groups = app.db().groups();

    ContactData newcontact = new ContactData()
            .withFirstname("namephoto")
            .withLastname("lastnamephoto")
            .withNickname("nick")
            .inGroup(groups.iterator().next());
    app.goTo().contactPage();
    app.contact().createwithoutdrop(newcontact);


  }*/


  public void testAddContactInGroup() {

    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    ContactData contact = contacts.iterator().next();
    GroupData group = groups.iterator().next();
    app.goTo().homePage();
    app.contact().ContactAddToGroup(contact, group);
    group.withGroupid(app.db().groups().stream().mapToInt(g -> g.getGroupid()).max().getAsInt());
    List<ContactData> after = new ArrayList<>();
    after.addAll(app.db().contacts());
    ContactData editedContact = after.get(after.indexOf(contact));
    assertThat(contact.getGroups().withAdded(group), equalTo(editedContact.getGroups()));

  }

  @Test
  public void testRemoveContactFromGroup() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    ContactData contact = contacts.iterator().next();
    GroupData group = groups.iterator().next();
    app.goTo().homePage();
    app.contact().removeContactFromGroup(contact, group);
    List<ContactData> after = new ArrayList<>();
    after.addAll(app.db().contacts());
    ContactData editedContact = after.get(after.indexOf(contact));
    assertThat(editedContact.getGroups(), equalTo(contact.getGroups().without(group)));

  }

}