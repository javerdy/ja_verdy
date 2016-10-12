package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Goblik on 27.08.2016.
 */
public class ContactHelper extends BaseHelper {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void pressEnter() {
    click(By.name("submit"));
    //new Select(wd.findElement(By.name("submit"))).selectByVisibleText("Enter");

  }

  public void fillContactForm(ContactData contactData, boolean creation) {

    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    wd.findElement(By.name("photo")).sendKeys("C:\\Users\\Goblik\\Pictures\\Utenok.jpg");
//    attach(By.name("photo"), contactData.getPhoto());
    type(By.name("title"), contactData.getTitle());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomepage());
    dropdownsel(wd.findElement(By.name("bday")), contactData.getBday());
    //new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    dropdownsel(wd.findElement(By.name("bmonth")), contactData.getBmonth());
    type(By.name("byear"), contactData.getYearbirth());
    dropdownsel(wd.findElement(By.name("aday")), contactData.getAday());
    dropdownsel(wd.findElement(By.name("amonth")), contactData.getAmonth());
    type(By.name("ayear"), contactData.getAnniver());
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("notes"), contactData.getNotes());
/*    if (creation) {
      dropdownsel(wd.findElement(By.name("new_group")), contactData.getNewgroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }*/

    if (creation) {
       if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getGroupname());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }


  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }


  public void editContact() {
    click(By.cssSelector("img[alt=\"Edit\"]"));
  }

  public void updateContact() {
    // click(By.xpath(".//*[@id='content']/form[1]/input[22]"));
    click(By.name("update"));

  }

  public void initContact() {
    click(By.linkText("add new"));

  }

  public void goToHomePage() {
/*    if (isElementPresent(By.id("maintable"))) {
      return;
    }*/
    click(By.linkText("home"));

  }

  public void create(ContactData contactdata, boolean b) {
    initContact();
    fillContCreationForm(contactdata, true);
    pressEnter();
    returnToContactPage();

  }
  public void createfull(ContactData contactdata, boolean b) {
    initContact();
    fillContactForm(contactdata, true);
    pressEnter();
    returnToContactPage();

  }

  public void createwithoutdrop(ContactData contactData) {
    initContact();
    modifysamll(contactData);
    pressEnter();
    returnToContactPage();
    contactCache = null;
  }

  public void fillContCreationForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    attach(By.name("photo"), contactData.getPhoto());
    type(By.name("title"), contactData.getTitle());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("homepage"), contactData.getHomepage());
 /*   dropdownsel(wd.findElement(By.name("bday")), contactData.getBday());
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    dropdownsel(wd.findElement(By.name("bmonth")), contactData.getBmonth());
    type(By.name("byear"), contactData.getYearbirth());
    dropdownsel(wd.findElement(By.name("aday")), contactData.getAday());
    dropdownsel(wd.findElement(By.name("amonth")), contactData.getAmonth());
    type(By.name("ayear"), contactData.getAnniver());
*/    type(By.name("address2"), contactData.getAddress2());
    type(By.name("notes"), contactData.getNotes());

  }

  public void modify(ContactData contactData) {
    click(By.linkText("home"));
    selectContactById(contactData.getId());
    editcontact(contactData.getId());
    modifysamll(contactData);
    updateContact();
    returnToContactPage();
  }

  private void editcontact(int index) {
    wd.findElement(By.cssSelector("td.center > a[href='edit.php?id=" + index + "']")).click();
  }

  private void modifysamll(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());

  }

  public boolean isThereaContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void returnToContactPage() {
/*    if (isElementPresent(By.id("maintable"))) {
      return;
    }*/
    click(By.linkText("home"));
  }


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();

  }

  public void createSmallContact(ContactData contactdata) {
    initContact();
    modify(contactdata);
    pressEnter();
    returnToContactPage();
  }


  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> contelements = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[1]"));
    for (WebElement element : contelements) {
      String firstname = element.findElement(By.xpath("//table[@id='maintable']/tbody/tr[29]/td[2]")).getText();
      String lastname = element.findElement(By.xpath("//table[@id='maintable']/tbody/tr[29]/td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }

/*  public Set<ContactData> allwithoutcash() {

    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(1).getText();
      String lastname = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");
      contacts.add(new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withHomePhone(phones[0])
              .withMobile(phones[1])
              .withWork(phones[2]));
    }
    return contacts;
  }*/

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withAddress(address)
              .withAllEmails(allEmails)
              .withAllPhones(allPhones));
    }
    return new Contacts(contactCache);

  }

/*  public Contacts alls() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements) {

      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastname = element.findElement(By.xpath("./td[2]")).getText();
      String firstname = element.findElement(By.xpath("./td[3]")).getText();
      String allPhones = element.findElement(By.xpath("./td[6]")).getText();
      String allEmails = element.findElement(By.xpath("./td[5]")).getText();
      String address = element.findElement(By.xpath("./td[4]")).getText();
      contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
    }
    return new Contacts(contactCache);
  }*/

  public Set<ContactData> alllistSplit() {

    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(1).getText();
      String lastname = cells.get(2).getText();
      String[] phones = cells.get(5).getText().split("\n");
      contacts.add(new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withHomePhone(phones[0])
              .withMobile(phones[1])
              .withWork(phones[2]));
    }
    return contacts;
  }

  public Set<ContactData> allmerge() {

    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String firstname = cells.get(1).getText();
      String lastname = cells.get(2).getText();
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      String allAddress = cells.get(3).getText();
      contacts.add(new ContactData()
              .withId(id)
              .withFirstname(firstname)
              .withLastname(lastname)
              .withAllPhones(allPhones)
              .withAllEmails(allEmails).withAddress(allAddress));

    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContModifyById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withHomePhone(homePhone)
            .withMobile(mobile)
            .withWork(work)
            .withAddress(address)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3);
  }


  public void contbyid(int id) {
    click(By.xpath("//a[contains(@href,'view.php?id=" + id + "')]"));
    //wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']", contact.getId()))).click();
  }

  public void initContModifyById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();

    returnToContactPage();

  }
/*  public  alertDel() {

    //wd.switchTo().alert().accept();
  try {
    wd.switchTo().alert();
    return true;
  } // try
  catch (Exception e) {
    return false;
  } // catch
  }*/

  public void deleteContact() {
    //click(By.xpath("//*[@onclick='DeleteSel()']"));
    //click(By.xpath("//input[@value='Delete']"));
    //click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();

  }

  public void delete(ContactData contact) {
    goToHomePage();
    selectConIdDel(contact.getId());
    deleteContact();
    wd.switchTo().alert().accept();
    contactCache = null;
    returnToContactPage();
  }

  public void selectConIdDel(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void selectContactById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(6).findElement(By.tagName("a")).click();

    //wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
/*    WebElement checkbox = wd.findElement(By.id("" + id));
    checkbox.findElement(By.xpath("./../../td[8]/a")).click();*/

  }

  public String getConfromcardForm(ContactData contactData) {
    readContactCardById(contactData.getId());
    String contactCardInfo = wd.findElement(By.xpath("//div[@id='content']")).getText();
    wd.navigate().back();
    return contactCardInfo;
  }

  private void readContactCardById(int id) {
    WebElement checkbox = wd.findElement(By.id("" + id));
    checkbox.findElement(By.xpath("//*[@id='maintable']//td[7]/a")).click();
  }

}
