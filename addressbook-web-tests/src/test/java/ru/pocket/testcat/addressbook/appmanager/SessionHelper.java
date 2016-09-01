package ru.pocket.testcat.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Goblik on 26.08.2016.
 */
public class SessionHelper extends BaseHelper {

  public SessionHelper(WebDriver wd) {

    super(wd);
  }

  public void login(String username, String pass) {
    type(By.name("user"),username);
    type(By.name("pass"),pass);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
