package Mailman;

import Interfaces.IOpazovalec;
import Models.Aktivnost;
import Models.Oseba;

import javax.jms.*;
import javax.naming.InitialContext;

public class Vrsta implements IOpazovalec
{
    @Override
    public void posodobi(Oseba o, Aktivnost a)
    {
        try
        {
            InitialContext ctx = new InitialContext();
            Queue queue = (Queue) ctx.lookup("java:/jms/queue/MyQueue");
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("java:jboss/exported/jms/RemoteConnectionFactory");
            QueueConnection cnn = factory.createQueueConnection("guest","guest");
            QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            QueueSender sender = session.createSender(queue);


            Message osM = session.createObjectMessage(a);
            sender.send(osM);
            System.out.println("Uspešno poslan message");
        }
        catch (Exception e){
            System.out.println("Messageing neki ne gre\n" + e);
        }
    }
}
