package ru.pocket.testcat.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

  private Set<ContactData> delegate;

  public Contacts(ru.pocket.testcat.addressbook.model.Contacts contact) {
    this.delegate = new HashSet<>(contact);
  }

  public Contacts() {
    this.delegate = new HashSet<>();
  }

  public Contacts(Collection<ContactData> contacts) {
    this.delegate = new HashSet<ContactData>(contacts);
  }



  @Override

  protected Set<ContactData> delegate() {
    return delegate;
  }

  public ru.pocket.testcat.addressbook.model.Contacts withAdded(ContactData contact) {
    ru.pocket.testcat.addressbook.model.Contacts contacts = new ru.pocket.testcat.addressbook.model.Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public ru.pocket.testcat.addressbook.model.Contacts without(ContactData contact) {
    ru.pocket.testcat.addressbook.model.Contacts contacts = new ru.pocket.testcat.addressbook.model.Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}



