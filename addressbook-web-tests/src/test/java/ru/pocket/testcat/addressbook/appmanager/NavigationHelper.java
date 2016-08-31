package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Goblik on 26.08.2016.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }
  public void addContactPage() {

    click(By.linkText("add new"));
  }

  public void homePage() {
    click(By.linkText("home"));
  }
  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }
}
