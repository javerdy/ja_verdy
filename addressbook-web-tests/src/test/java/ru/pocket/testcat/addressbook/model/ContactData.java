package ru.pocket.testcat.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String nickname;
  private final String title;
  private final String address;
  private final String homePhone;
  private final String mobile;
  private final String workPhone;
  private final String fax;
  private final String email;
  private final String homepage;
  private final String address2;
  private final String notes;
  private final String yearbirth;
  private final String anniver;
  private final String bday;
  private final String bmonth;
  private final String aday;
  private final String amonth;
  private final String newgroup;


  public ContactData(String firstname, String lastname, String nickname, String title, String address, String homePhone, String mobile, String workPhone, String fax, String email, String homepage, String address2, String notes, String yearbirth, String anniver, String bday, String bmonth, String aday, String amonth, String newgroup) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.nickname = nickname;
    this.title = title;
    this.address = address;
    this.homePhone = homePhone;
    this.mobile = mobile;
    this.workPhone = workPhone;
    this.fax = fax;
    this.email = email;
    this.homepage = homepage;
    this.address2 = address2;
    this.notes = notes;
    this.yearbirth = yearbirth;
    this.anniver = anniver;
    this.bday = bday;
    this.bmonth = bmonth;
    this.aday = aday;
    this.amonth = amonth;
    this.newgroup = newgroup;
  }


  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail() {
    return email;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getAddress2() {
    return address2;
  }

  public String getNotes() {
    return notes;
  }

  public String getYearbirth() {
    return yearbirth;
  }

  public String getAnniver() {
    return anniver;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getAday() {
    return aday;
  }

  public String getAmonth() {
    return amonth;
  }

  public String getNewgroup() {
    return newgroup;
  }

}
