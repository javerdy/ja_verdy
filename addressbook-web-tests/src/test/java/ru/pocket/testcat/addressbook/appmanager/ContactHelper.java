package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.pocket.testcat.addressbook.model.ContactData;

/**
 * Created by Goblik on 27.08.2016.
 */
public class ContactHelper extends BaseHelper {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void homePage() {
    click(By.linkText("home"));
  }

  public void pressEnter() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData, String bmonth, String aday, String amonth, String newgroup) {
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
    new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(bmonth);
    type(By.name("byear"), contactData.getYearbirth());
    new Select(wd.findElement(By.name("aday"))).selectByVisibleText(aday);
    new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(amonth);
    type(By.name("ayear"), contactData.getAnniver());
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(newgroup);
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("notes"), contactData.getNotes());

  }



  public void addContactPage() {

    click(By.linkText("add new"));
  }
}
