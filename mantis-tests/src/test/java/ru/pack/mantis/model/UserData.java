package ru.pack.mantis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Goblik on 16.10.2016.
 */

@Entity
@Table(name = "mantis_user_table")
public class UserData {


  @Id
  private int id;
  private String username = "";
  private String email = "";
  private String password = "";

  public int getId() {
    return id;
  }

  public UserData setId(int id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return username;
  }

  public UserData setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserData setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserData setEmail(String email) {
    this.email = email;
    return this;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("UserData{");
    sb.append("username='").append(username).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append('}');
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData that = (UserData) o;

    if (username != null ? !username.equals(that.username) : that.username != null) return false;
    if (password != null ? !password.equals(that.password) : that.password != null) return false;
    return email != null ? email.equals(that.email) : that.email == null;

  }

  @Override
  public int hashCode() {
    int result = username != null ? username.hashCode() : 0;
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    return result;
  }
}

