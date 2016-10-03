package ru.pocket.testcat.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("group")
public class GroupData {
  @XStreamOmitField
  public int groupid = Integer.MAX_VALUE;
  @Expose
  public String groupname;
  @Expose
  public String groupheader;
  @Expose
  public String groupfooter;

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


  @Override
  public String toString() {
    return "GroupData{" +
            "groupheader='" + groupheader + '\'' +
            ", groupname='" + groupname + '\'' +
            '}';
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
