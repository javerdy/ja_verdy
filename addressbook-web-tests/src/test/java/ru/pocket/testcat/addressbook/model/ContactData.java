package ru.pocket.testcat.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  ;
  private String firstname;
  private String lastname;
  private String nickname;
  private String title;
  private String address;
  private String homePhone;
  private String mobile;
  private String workPhone;
  private String fax;
  private String allPhones;
  private String email;
  private String email2;
  private String email3;
  private String allEmails;
  private String homepage;
  private String address2;
  private String notes;
  private String yearbirth;
  private String anniver;
  private String newgroup;
  private String bday;
  private String bmonth;
  private String aday;
  private String amonth;
  private String photo;
  private String allAddress;


  public void setId(int id) {
    this.id = id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }


  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail(String mail) {
    this.email = mail;
    return this;
  }
  public ContactData withEmail2(String mail2) {
    this.email2 = mail2;
    return this;
  }

  public ContactData withEmail3(String mail3) {
    this.email3 = mail3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }
  public ContactData withAlladdress(String allAddress) {
    this.allAddress = allAddress;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData homePage(String home) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withYearbirth(String yearbirth) {
    this.yearbirth = yearbirth;
    return this;
  }

  public ContactData withAnniver(String anniver) {
    this.anniver = anniver;
    return this;
  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }


  public int getId() {
    return id;
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

  public String getPhoto() {
    return photo;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", title='" + title + '\'' +
            ", address='" + address + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobile='" + mobile + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", fax='" + fax + '\'' +
            ", allPhones='" + allPhones + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", allEmails='" + allEmails + '\'' +
            ", homepage='" + homepage + '\'' +
            ", address2='" + address2 + '\'' +
            ", notes='" + notes + '\'' +
            ", yearbirth='" + yearbirth + '\'' +
            ", anniver='" + anniver + '\'' +
            ", newgroup='" + newgroup + '\'' +
            ", bday='" + bday + '\'' +
            ", bmonth='" + bmonth + '\'' +
            ", aday='" + aday + '\'' +
            ", amonth='" + amonth + '\'' +
            ", photo='" + photo + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
    if (title != null ? !title.equals(that.title) : that.title != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
    if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
    if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
    if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
    if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    if (allEmails != null ? !allEmails.equals(that.allEmails) : that.allEmails != null) return false;
    if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null) return false;
    if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;
    if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
    if (yearbirth != null ? !yearbirth.equals(that.yearbirth) : that.yearbirth != null) return false;
    if (anniver != null ? !anniver.equals(that.anniver) : that.anniver != null) return false;
    if (newgroup != null ? !newgroup.equals(that.newgroup) : that.newgroup != null) return false;
    if (bday != null ? !bday.equals(that.bday) : that.bday != null) return false;
    if (bmonth != null ? !bmonth.equals(that.bmonth) : that.bmonth != null) return false;
    if (aday != null ? !aday.equals(that.aday) : that.aday != null) return false;
    if (amonth != null ? !amonth.equals(that.amonth) : that.amonth != null) return false;
    return photo != null ? photo.equals(that.photo) : that.photo == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
    result = 31 * result + (fax != null ? fax.hashCode() : 0);
    result = 31 * result + (allPhones != null ? allPhones.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (allEmails != null ? allEmails.hashCode() : 0);
    result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
    result = 31 * result + (address2 != null ? address2.hashCode() : 0);
    result = 31 * result + (notes != null ? notes.hashCode() : 0);
    result = 31 * result + (yearbirth != null ? yearbirth.hashCode() : 0);
    result = 31 * result + (anniver != null ? anniver.hashCode() : 0);
    result = 31 * result + (newgroup != null ? newgroup.hashCode() : 0);
    result = 31 * result + (bday != null ? bday.hashCode() : 0);
    result = 31 * result + (bmonth != null ? bmonth.hashCode() : 0);
    result = 31 * result + (aday != null ? aday.hashCode() : 0);
    result = 31 * result + (amonth != null ? amonth.hashCode() : 0);
    result = 31 * result + (photo != null ? photo.hashCode() : 0);
    return result;
  }
}
