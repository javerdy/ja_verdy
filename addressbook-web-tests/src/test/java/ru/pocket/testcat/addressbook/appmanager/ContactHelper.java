package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.pocket.testcat.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

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
    type(By.name("title"), contactData.getTitle());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
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
    if (creation) {
      dropdownsel(wd.findElement(By.name("new_group")), contactData.getNewgroup());
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
    click(By.xpath(".//*[@id='content']/form[1]/input[22]"));

  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));

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

  public void create(ContactData contactdata) {
    initContact();
    fillContCreationForm(contactdata, true);
    pressEnter();
    returnToContactPage();

  }

  public void fillContCreationForm(ContactData contactData, boolean creat) {

    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    //wd.findElement(By.name("photo")).sendKeys("C:\\Users\\Goblik\\Pictures\\Utenok.jpg");
    type(By.name("title"), contactData.getTitle());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmail());
    type(By.name("homepage"), contactData.getHomepage());
//    dropdownsel(wd.findElement(By.name("bday")), contactData.getBday());
//    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
    //   dropdownsel(wd.findElement(By.name("bmonth")), contactData.getBmonth());
    type(By.name("byear"), contactData.getYearbirth());
    //  dropdownsel(wd.findElement(By.name("aday")), contactData.getAday());
//    dropdownsel(wd.findElement(By.name("amonth")), contactData.getAmonth());
    type(By.name("ayear"), contactData.getAnniver());
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("notes"), contactData.getNotes());

  }

  public void fillContSmallForm(ContactData contactData) {

    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
  }

  public boolean isThereaContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));

  }

  public void alertDel() {
    wd.switchTo().alert().accept();
  }


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();

  }

  public void createSmallContact(ContactData contactdata) {
    initContact();
    fillContSmallForm(contactdata);
    pressEnter();
    returnToContactPage();

  }

  public void delete(int index) {
    selectContact(index);
    deleteContact();
    returnToContactPage();
    alertDel();
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


}