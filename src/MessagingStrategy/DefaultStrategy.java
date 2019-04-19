package MessagingStrategy;

import Mailman.Email;
import Models.Aktivnost;

public class DefaultStrategy implements IMessagingStrategy
{
    @Override
    public void DoIt(Aktivnost aktivnost)
    {
        String message = "Dodali ste novo aktivnost";
        Email mail = new Email();
        mail.sendMail(aktivnost.getOsebaLastnik(), aktivnost, message);
    }
}
