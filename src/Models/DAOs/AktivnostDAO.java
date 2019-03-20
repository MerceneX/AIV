package Models.DAOs;

import Mailman.Email;
import Mailman.Logger;
import Models.Aktivnost;
import Models.Oseba;

import java.util.ArrayList;

public class AktivnostDAO
{
    private ArrayList<Aktivnost> aktivnosti = new ArrayList<>();

    private AktivnostDAO()
    {
    }

    private static AktivnostDAO dao = new AktivnostDAO();

    public static AktivnostDAO getInstance()
    {
        return dao;
    }

    public void dodaj(Aktivnost aktivnost, Oseba o)
    {
        Aktivnost najdenaAktivnost = najdiAktivnostPoNazivu(aktivnost.getNaziv());
        if (najdenaAktivnost == null)
        {
            Aktivnost copyAktivnost = new Aktivnost(aktivnost);
            aktivnosti.add(copyAktivnost);
            Email mail = new Email();
            Logger log = new Logger();
            aktivnost.prijavi(mail);
            aktivnost.prijavi(log);
            copyAktivnost.obvesti();

        } else
        {
            posodobiAktivnost(najdenaAktivnost, aktivnost);
        }
    }

    public Aktivnost najdiAktivnostPoNazivu(String naziv)
    {
        for (Aktivnost a : aktivnosti)
        {
            if (a.getNaziv().equals(naziv))
            {
                return a;
            }
        }
        return null;
    }

    public void posodobiAktivnost(Aktivnost stara, Aktivnost nova){
        stara.setKm(nova.getKm());
        stara.setDatumAktivnosti(nova.getDatumAktivnosti());
        stara.setLastnik(nova.getLastnik());
        nova.obvesti();
    }

    public ArrayList<Aktivnost> vrniVse()
    {
        return aktivnosti;
    }

    public ArrayList<Aktivnost> getAktivnosti()
    {
        return aktivnosti;
    }

    public void setAktivnosti(ArrayList<Aktivnost> aktivnosti)
    {
        this.aktivnosti = aktivnosti;
    }

}
