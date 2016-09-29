package ru.pocket.testcat.addressbook.model;

public class GroupData {
  private int groupid = Integer.MAX_VALUE;
  private String groupname;
  private String groupheader;
  private String groupfooter;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return groupname != null ? groupname.equals(groupData.groupname) : groupData.groupname == null;

  }

  @Override
  public int hashCode() {
    return groupname != null ? groupname.hashCode() : 0;
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
