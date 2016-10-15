package ru.pack.mantis.model;

/**
 * Created by Goblik on 15.10.2016.
 */
public class MailMessage {
  public String to;
  public String text;

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}
