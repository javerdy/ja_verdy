package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import ru.pocket.testcat.addressbook.model.ContactData;

/**
 * Created by Goblik on 26.08.2016.
 */
public class BaseHelper {
  protected FirefoxDriver wd;

  public BaseHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }
  public void dropdownsel(ContactData contactData) {
    new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
