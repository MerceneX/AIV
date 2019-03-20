package Mailman;

import Interfaces.IOpazovalec;
import Models.Aktivnost;

public class Logger implements IOpazovalec
{
    @Override
    public void posodobi(String o, Aktivnost a)
    {
        System.out.println(o + " je spremenil aktivnost " + a.getNaziv());
    }
}
