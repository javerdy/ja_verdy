package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.pocket.testcat.addressbook.model.ContactData;

/**
 * Created by Goblik on 27.08.2016.
 */
public class ContactHelper extends BaseHelper {


  public ContactHelper(FirefoxDriver wd){
    super (wd);
  }

  public void homePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void pressEnter() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("nickname"),contactData.getNickname());
    type(By.name("title"),contactData.getTitle());
    type(By.name("address"),contactData.getAddress());
    type(By.name("home"),contactData.getHomePhone());
    type(By.name("mobile"),contactData.getMobile());
    type(By.name("work"),contactData.getWorkPhone());
    type(By.name("fax"),contactData.getFax());
    type(By.name("email"),contactData.getEmail());
    type(By.name("homepage"),contactData.getHomepage());
    click(By.xpath("//div[@id='content']/form/select[1]//option[16]"));
    click(By.xpath("//div[@id='content']/form/select[2]//option[12]"));
    type(By.name("byear"),contactData.getYearbirth());
    click(By.xpath("//div[@id='content']/form/select[3]//option[12]"));
    click(By.xpath("//div[@id='content']/form/select[4]//option[9]"));
    type(By.name("ayear"),contactData.getAnniver());
    click(By.xpath("//div[@id='content']/form/select[5]//option[8]"));
    type(By.name("address2"),contactData.getAddress2());
    type(By.name("notes"),contactData.getNotes());

  }

  public void addContactPage() {

    wd.findElement(By.linkText("add new")).click();
  }
}
