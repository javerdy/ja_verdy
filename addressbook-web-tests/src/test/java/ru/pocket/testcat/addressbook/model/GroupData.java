package ru.pocket.testcat.addressbook.model;

public class GroupData {
  private int groupid;
  private final String groupname;
  private final String groupheader;
  private final String groupfooter;

  public void setGroupid(int groupid) {
    this.groupid = groupid;
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
    result = 31 * result + (groupname !=null ? groupname.hashCode() : 0 );
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "groupheader='" + groupheader + '\'' +
            ", groupname='" + groupname + '\'' +
            '}';
  }



  public GroupData( int groupid, String groupname, String groupheader, String groupfooter) {
    this.groupid = groupid;
    this.groupname = groupname;
    this.groupheader = groupheader;
    this.groupfooter = groupfooter;


  }

  public GroupData(String groupname, String groupheader, String groupfooter) {
    this.groupid = 0;
    this.groupname = groupname;
    this.groupheader = groupheader;
    this.groupfooter = groupfooter;


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
