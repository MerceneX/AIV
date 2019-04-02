package Mailman;

import Interfaces.IOpazovalec;
import Models.Aktivnost;
import Models.Oseba;

public class Logger implements IOpazovalec
{
    @Override
    public void posodobi(Oseba o, Aktivnost a)
    {
        System.out.println(o.getIme() + " je spremenil aktivnost " + a.getNaziv());
    }
}
