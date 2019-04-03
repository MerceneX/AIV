package Zrna;

import Mailman.Email;
import Models.Aktivnost;
import Models.Oseba;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

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
                System.out.println(tm.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(message instanceof ObjectMessage){
            ObjectMessage objectMessage = (ObjectMessage)message;
            try
            {
                Aktivnost a = (Aktivnost)objectMessage.getObject();
                Oseba o = a.getOsebaLastnik();
                mailman.sendMail(o,a);
            } catch (JMSException e)
            {
                e.printStackTrace();
            }
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