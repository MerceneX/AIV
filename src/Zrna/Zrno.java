package Zrna;


import Models.Aktivnost;
import Models.DAOs.AktivnostDAO;
import Models.Oseba;
import Models.DAOs.OsebaDAO;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named("zrno")
@SessionScoped
public class Zrno implements Serializable
{
    private Oseba oseba = new Oseba();
    private Aktivnost aktivnost = new Aktivnost();
    private OsebaDAO osebaDAO = OsebaDAO.getInstance();
    private AktivnostDAO aktivnostDAO = AktivnostDAO.getInstance();

    public OsebaDAO getOsebaDAO()
    {
        return osebaDAO;
    }

    public void dodajOsebo()
    {
        Oseba copyOseba = new Oseba(oseba);
        osebaDAO.dodajOsebno(copyOseba);
        oseba = new Oseba();
    }

    public ArrayList<Oseba> vrniVseOsebe()
    {
        return osebaDAO.vrniVse();
    }

    public void dodajAktivnost()
    {
        Aktivnost copyAktivnost = new Aktivnost(aktivnost);
        aktivnostDAO.dodaj(copyAktivnost, osebaDAO.najdiOseboPoImenu(aktivnost.getLastnik()));
        aktivnost = new Aktivnost();
    }

    public String vrniUrejanjePoImenu(String ime)
    {
        oseba = osebaDAO.najdiOseboPoImenu(ime);
        return "index.xhtml";
    }

    public String vrniUrejanjePoNazivu(String naziv)
    {
        aktivnost = aktivnostDAO.najdiAktivnostPoNazivu(naziv);
        return "aktivnost.xhtml";
    }

    public ArrayList<Aktivnost> vrniVseAktivnosti()
    {
        return aktivnostDAO.vrniVse();
    }

    public Oseba getOseba()
    {
        return oseba;
    }

    public void setOseba(Oseba oseba)
    {
        this.oseba = oseba;
    }

    public void setOsebaDAO(OsebaDAO osebaDAO)
    {
        this.osebaDAO = osebaDAO;
    }

    public Aktivnost getAktivnost()
    {
        return aktivnost;
    }

    public void setAktivnost(Aktivnost aktivnost)
    {
        this.aktivnost = aktivnost;
    }

    public AktivnostDAO getAktivnostDAO()
    {
        return aktivnostDAO;
    }

    public void setAktivnostDAO(AktivnostDAO aktivnostDAO)
    {
        this.aktivnostDAO = aktivnostDAO;
    }
}
