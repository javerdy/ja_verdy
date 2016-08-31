package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.pocket.testcat.addressbook.model.ContactData;

/**
 * Created by Goblik on 27.08.2016.
 */
public class ContactHelper extends BaseHelper {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }


  public void pressEnter() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
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
    dropdownsel(wd.findElement(By.name("new_group")), contactData.getNewgroup());
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("notes"), contactData.getNotes());

  }
  public void selectContact() {
    click(By.name("selected[]"));
  }


  public void editContact(){
    wd.findElement(By.cssSelector("img[alt=\"Edit\"]")).click();
  }
  public void updateContact() {
    wd.findElement(By.xpath("/div[4]/form[1]/input[22]")).click();

  }
  public void deleteContact (){
    wd.findElement(By.xpath("//div/div[4]/form[2]/div")).click();

  }

}
