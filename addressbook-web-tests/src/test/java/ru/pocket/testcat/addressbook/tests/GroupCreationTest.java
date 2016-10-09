package ru.pocket.testcat.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

/*  @DataProvider
  public Iterator<Object[]> validGroups() throws IOException {

    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader =new BufferedReader(new FileReader(new File("scr/test/resources/groups.csv")));
    String line = reader.readLine();
    while (line !=null){
      String[] split = line.split(";");
      list.add(new Object[]{new GroupData().withGroupname(split[0]).withGroupheader(split[1]).withGroupfooter(split[2])});
       line = reader.readLine();
           return list.iterator();
  }
    }*/
  @DataProvider
  public Iterator<Object[]> validGroupsFromXML() throws IOException {
 //   List<Object[]> list = new ArrayList<Object[]>();
    try (
    BufferedReader reader = new BufferedReader(new FileReader
            (new File("src/test/resources/groups.xml"))))  {
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml +=line;
/*      String[] split = line.split(";");
      list.add(new Object[]{new GroupData().withGroupname(split[0]).withGroupheader(split[1]).withGroupfooter(split[2])});*/
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups =(List<GroupData>) xstream.fromXML(xml);
   return groups.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
  }}

  @DataProvider
  public Iterator<Object[]> validGroupsFromJSON() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader
            (new File("src/test/resources/groups.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
      }.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }
 /*   list.add(new Object[] {new GroupData().withGroupname("test1").withGroupheader("header2").withGroupfooter("footer1")});
    list.add(new Object[] {new GroupData().withGroupname("test2").withGroupheader("header2").withGroupfooter("footer2")});
    list.add(new Object[] {new GroupData().withGroupname("test3").withGroupheader("header3").withGroupfooter("footer3")});*/


  @Test (dataProvider = "validGroupsFromJSON")
  public void testGroupCreation(GroupData group) {
   // GroupData group = new GroupData().withGroupname(name).withGroupheader(header).withGroupfooter(footer);
    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().getgroupCount(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.withAdded(group.withGroupid(after.stream().mapToInt((g) ->g.getGroupid()).max().getAsInt()))));
  }

  @Test (dataProvider = "validGroupsFromJSON")
  public void testAssertCreationGroupFromDb(GroupData group) {
    Groups before = app.db().groups();
    app.goTo().groupPage();
    app.group().create(group);
    assertThat(app.group().getgroupCount(), equalTo(before.size() + 1));
    Groups after = app.db().groups();
    assertThat(after, equalTo
            (before.withAdded(group.withGroupid(after.stream().mapToInt((g) ->g.getGroupid()).max().getAsInt()))));
  }


  @Test (enabled = false)
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withGroupname("test21'");
    app.group().create(group);
    assertThat(app.group().getgroupCount (), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }
}
//первый метод
/*    int max = 0;
    for(GroupData g: after){
      if (g.getGroupid() >max) {
        max = g.getGroupid();
      }
    }*/

    // второй метод


   // int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getGroupid(), o2.getGroupid())).get().getGroupid();

/*    Comparator<? super GroupData> byId = new Comparator<GroupData>() {
      @Override
      public int compare(GroupData o1, GroupData o2) {
        return Integer.compare(o1.getGroupid(), o2.getGroupid());
      }
    };*/



/*    app.goTo().groupPage();
    int before = app.group().getgroupCount ();
    app.group().create(new GroupData("newgroup", null, null));
    int after = app.group().getgroupCount();
    Assert.assertEquals(after, before + 1);*/
