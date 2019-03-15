package Models.DAOs;

import Models.Aktivnost;

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

    public void dodaj(Aktivnost aktivnost)
    {
        Aktivnost najdenaAktivnost = najdiAktivnostPoNazivu(aktivnost.getNaziv());
        if (najdenaAktivnost == null)
        {
            aktivnosti.add(aktivnost);
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
