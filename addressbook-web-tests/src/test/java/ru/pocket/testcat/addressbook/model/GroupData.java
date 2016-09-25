package ru.pocket.testcat.addressbook.model;

public class GroupData {
  private final String groupname;
  private final String groupheader;
  private final String groupfooter;
  private final String groupid;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (groupname != null ? !groupname.equals(groupData.groupname) : groupData.groupname != null) return false;
    return groupheader != null ? groupheader.equals(groupData.groupheader) : groupData.groupheader == null;

  }

  @Override
  public int hashCode() {
    int result = groupname != null ? groupname.hashCode() : 0;
    result = 31 * result + (groupheader != null ? groupheader.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "groupheader='" + groupheader + '\'' +
            ", groupname='" + groupname + '\'' +
            '}';
  }



  public GroupData(String groupname, String groupheader, String groupfooter, String groupid) {
    this.groupname = groupname;
    this.groupheader = groupheader;
    this.groupfooter = groupfooter;
    this.groupid = groupid;

  }

  public GroupData(String groupname, String groupheader, String groupfooter) {
    this.groupname = groupname;
    this.groupheader = groupheader;
    this.groupfooter = groupfooter;
    this.groupid = null;

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
  public String getGroupid() {
    return groupid;
  }

}
