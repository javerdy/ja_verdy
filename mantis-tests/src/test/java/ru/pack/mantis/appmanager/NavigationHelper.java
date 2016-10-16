package ru.pack.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by Goblik on 16.10.2016.
 */
public class NavigationHelper extends HelperBase{

  public NavigationHelper(ApplicationManadger app) {
    super(app);
  }

  public void manageUsersPage() {
    managePage();
    click(By.xpath("//a[contains(@href, 'manage_user_page.php')]"));
  }

  private void managePage() {
    click(By.xpath("//a[contains(@href, 'manage_overview_page.php')]"));
  }

  public void editUserPage(int id) {
    click(By.xpath("//a[contains(@href, 'user_id=" + id + "')]"));

  }
}
