package MessagingStrategy;

import Mailman.Email;
import Models.Aktivnost;

public class FormalStrategy implements IMessagingStrategy
{

    @Override
    public void DoIt(Aktivnost aktivnost)
    {
        String message = "Dodali ste novo aktivnost gospod ";
        Email mail = new Email();
        mail.sendMail(aktivnost.getOsebaLastnik(), aktivnost, message);
    }
}
