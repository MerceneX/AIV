package Mailman;

import Interfaces.IOpazovalec;
import Models.Aktivnost;
import Models.Oseba;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class Email implements IOpazovalec
{
    @Resource(lookup = "java:jboss/mail/gmail")
    private Session session;

    public void posodobi(Oseba os, Aktivnost a)
    {
        sendMail(os, a);
    }

    public void sendMail(Oseba os, Aktivnost a){
        try
        {
            InitialContext ic = new InitialContext();
            session = (Session) ic.lookup("java:jboss/mail/gmail");
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(os.getEmail()));
            message.setSubject("Sprememba aktivnosti");
            message.setText(a.getNaziv() + " se je spremenilo");
            Transport.send(message);

        } catch (MessagingException | NamingException e)
        {
            Logger.getLogger(Email.class.getName()).log(Level.WARNING, "Cannot posodobi mail", e);
        }
    }
}
