package Mailman;

import Interfaces.IOpazovalec;
import Models.Aktivnost;
import Models.DAOs.IDAOs.IOsebaDAO;
import Models.Oseba;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
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
    org.slf4j.Logger log = LoggerFactory.getLogger(Email.class);
    IOsebaDAO osebaDAO;
    String o;
    Aktivnost a;

    public void posodobi(String o, Aktivnost a)
    {
        Oseba os = osebaDAO.najdiOseboPoImenu(o);
        try
        {
            InitialContext ic = new InitialContext();
            session = (Session) ic.lookup("java:jboss/mail/gmail");
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(os.getEmail()));
            message.setSubject("Sprememba aktivnosti");
            message.setText(a.getNaziv() + "se je spremenilo");
            //Transport.send(message);

        } catch (MessagingException | NamingException e)
        {
            Logger.getLogger(Email.class.getName()).log(Level.WARNING, "Cannot posodobi mail", e);
        }
    }
}
