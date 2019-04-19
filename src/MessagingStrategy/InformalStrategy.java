package MessagingStrategy;

import Mailman.Email;
import Models.Aktivnost;

public class InformalStrategy implements IMessagingStrategy
{

    @Override
    public void DoIt(Aktivnost aktivnost)
    {
        String message = "Novo aktiunost imaš kolega ";
        Email mail = new Email();
        mail.sendMail(aktivnost.getOsebaLastnik(), aktivnost, message);
    }
}
