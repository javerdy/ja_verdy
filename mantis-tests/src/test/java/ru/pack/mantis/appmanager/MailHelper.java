package ru.pack.mantis.appmanager;

import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.pack.mantis.model.MailMessage;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Created by Goblik on 15.10.2016.
 */

public class MailHelper {

  private final Wiser wiser;
  public ApplicationManadger app;

  public MailHelper(ApplicationManadger app) {
    this.app = app;
    wiser = new Wiser();
  }

  public static MailMessage toModelMail(WiserMessage m) {
    try {
      MimeMessage mm = m.getMimeMessage();
      return new MailMessage(mm.getAllRecipients()[0].toString(), (String) mm.getContent());
    } catch (MessagingException e) {
      e.printStackTrace();
      return null;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<MailMessage> waitForMail(int count, long timeout) {
    long start = System.currentTimeMillis();
    while (System.currentTimeMillis() < start + timeout) {
      if (wiser.getMessages().size() >= count) {
        return wiser.getMessages().stream().map((m) -> toModelMail(m)).collect(Collectors.toList());
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    throw new Error("No mail : (");
  }

  public void start() {
    wiser.start();
  }

  public void stop() {
    wiser.stop();
  }


  public String confirmLink(String email) {
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 100000);
    MailMessage mailMessage = mailMessages.stream().filter(m -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  public String changePasswordLink(String email) {
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 100000);
    MailMessage mailMessage = mailMessages.stream().filter(m -> m.to.equals(email) && m.text.contains("password change")).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }


}
