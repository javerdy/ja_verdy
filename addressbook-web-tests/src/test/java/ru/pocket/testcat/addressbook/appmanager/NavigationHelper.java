package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Goblik on 26.08.2016.
 */
public class NavigationHelper extends BaseHelper {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {

      return;
    }
    click(By.linkText("groups"));
  }

  public void contactPage() {

    click(By.linkText("add new"));
  }
  public void homePage() {

    click(By.linkText("home"));
  }
}
