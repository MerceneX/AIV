package Zrna;

import Mailman.Email;
import Models.Aktivnost;
import Models.Oseba;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(messageListenerInterface = MessageListener.class,
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/MyQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),

    })
public class SVZrno implements MessageListener
{
    Oseba o;
    Aktivnost a;
    Email mailman;

    public SVZrno()
    {
        mailman = new Email();
    }

    public void onMessage(Message message) {

        if (message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            try {
                mailman.sendMail(o,a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Prispelo je neznano sporoèilo.");
        }
    }

    public Oseba getO()
    {
        return o;
    }

    public void setO(Oseba o)
    {
        this.o = o;
    }

    public Aktivnost getA()
    {
        return a;
    }

    public void setA(Aktivnost a)
    {
        this.a = a;
    }
}