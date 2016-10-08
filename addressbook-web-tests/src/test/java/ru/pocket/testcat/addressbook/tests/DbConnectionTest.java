package ru.pocket.testcat.addressbook.tests;

import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.GroupData;
import ru.pocket.testcat.addressbook.model.Groups;


import java.sql.*;
/**
 * Created by Goblik on 08.10.2016.
 */
public class DbConnectionTest {

    @Test
    public void testDbConnection() {
      Connection conn = null;
      try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
        // Do something with the Connection
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
        Groups groups = new Groups();
        while (rs.next()) {
          groups.add(new GroupData().withGroupid(rs.getInt("group_id")).withGroupname(rs.getString("group_name")).
                  withGroupheader(rs.getString("group_header")).withGroupfooter(rs.getString("group_footer")));
        }
        rs.close();
        st.close();
        conn.close();

        System.out.println(groups);
        System.out.println("Групп всего " + groups.size());

      } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
      }
    }
  }

