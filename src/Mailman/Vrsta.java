package Mailman;

import Interfaces.IOpazovalec;
import Models.Aktivnost;
import Models.Oseba;
import Zrna.SVZrno;

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

            SVZrno svz = new SVZrno();
            svz.setA(a);
            svz.setO(o);

            sender.send(session.createTextMessage("Serbus!"));
            sender.send(session.createTextMessage("Pa spet serbus."));
            sender.send(session.createTextMessage("Pa se enkrat! Naslednič daš za pir :)"));

            //sporoèilo, ki ni trajno
            Message m=session.createTextMessage("NETRAJNO SPOROCILO");
            Message osM = session.createObjectMessage(a);
            sender.send(osM);
            sender.send(m,DeliveryMode.NON_PERSISTENT,3,2000);

            //sporoèilo, ki je trajno
            m=session.createTextMessage("TRAJNO SPOROCILO");
            sender.send(m,DeliveryMode.PERSISTENT,3,10000);
            session.close();
            System.out.println("Uspešno poslan message");
        }
        catch (Exception e){
            System.out.println("Messageing neki ne gre\n" + e);
        }
    }
}
