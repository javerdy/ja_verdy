package ru.pack.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import ru.pack.mantis.model.UserData;


import java.util.List;

/**
 * Created by Goblik on 16.10.2016.
 */
public class DbHelper {
  private final SessionFactory sessionFactory;


  public DbHelper() {

    final ServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public List<UserData> users() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData where id != 1").list();
    session.getTransaction().commit();
    session.close();
    return result;
  }
}
