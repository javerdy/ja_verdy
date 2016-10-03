package ru.pocket.testcat.addressbook.generators;

import ru.pocket.testcat.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

/**
 * Created by Goblik on 03.10.2016.
 */
public class GroupdataGenerator {


  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<GroupData> groups = generateGroups(count);
    save(groups, file);
  }

  private static void save(List<GroupData> groups, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (GroupData group: groups) {
      writer.write(String.format("%s;%s;%s;\n", group.getGroupname(),group.getGroupheader(),group.getGroupfooter()));
    }

    writer.close();
  }

  private static List<GroupData> generateGroups(int count) {
    List<GroupData> groups = new ArrayList<GroupData>();
    for (int i = 0; i < count; i++) {
      groups.add(new GroupData().withGroupname(String.format("test %s", i))
              .withGroupheader(String.format("header %s", i)).withGroupfooter(String.format("footer %s", i)));
    }
    return groups;
  }
}
