package ru.pocket.testcat.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@XStreamAlias("group")
@Entity
@Table(name ="group_list")
public class GroupData {

  @Override
  public String toString() {
    return "GroupData{" +
            "groupid=" + groupid +
            ", groupname='" + groupname + '\'' +
            ", groupheader='" + groupheader + '\'' +
            ", groupfooter='" + groupfooter + '\'' +
            '}';
  }

  @XStreamOmitField
  @Id
  @Column(name ="group_id")
  public int groupid = Integer.MAX_VALUE;

  @Expose
  @Column(name = "group_name")
  public String groupname;

  @Expose
  @Column(name = "group_header")
  @Type(type="text")
  public String groupheader;

  @Expose
  @Column(name = "group_footer")
  @Type(type="text")
  public String groupfooter;

  public Contacts getContacts() {
    return new Contacts(contacts);
  }

  @ManyToMany(mappedBy = "groups")
  private Set<ContactData> contacts = new HashSet<ContactData>();

  public GroupData withGroupid(int groupid) {
    this.groupid = groupid;
    return this;
  }

  public GroupData withGroupheader(String groupheader) {
    this.groupheader = groupheader;
    return this;

  }

  public GroupData withGroupname(String groupname) {
    this.groupname = groupname;
    return this;

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (groupid != groupData.groupid) return false;
    return groupname != null ? groupname.equals(groupData.groupname) : groupData.groupname == null;

  }

  @Override
  public int hashCode() {
    int result = groupid;
    result = 31 * result + (groupname != null ? groupname.hashCode() : 0);
    return result;
  }

  public GroupData withGroupfooter(String groupfooter) {

    this.groupfooter = groupfooter;
    return this;


  }


  public String getGroupname() {
    return groupname;
  }

  public String getGroupheader() {
    return groupheader;
  }

  public String getGroupfooter() {
    return groupfooter;
  }
  public int getGroupid() {
    return groupid;
  }

}
