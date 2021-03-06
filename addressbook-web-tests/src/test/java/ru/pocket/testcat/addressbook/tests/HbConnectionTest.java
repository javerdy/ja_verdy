package ru.pocket.testcat.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.pocket.testcat.addressbook.model.ContactData;
import ru.pocket.testcat.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Goblik on 09.10.2016.
 */
public class HbConnectionTest {

  private SessionFactory sessionFactory;


  @BeforeClass
  protected void setUp() throws Exception {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {

      e.printStackTrace();

      StandardServiceRegistryBuilder.destroy( registry );
    }
  }


  @Test
  public void testHbConnection() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("From GroupData").list();
    for (GroupData group : result) {
      System.out.println(group);

    }
    session.getTransaction().commit();
    session.close();

  }
}