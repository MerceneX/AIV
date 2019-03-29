package Zrna;


import Models.Aktivnost;
import Models.DAOs.IDAOs.IAktivnostDAO;
import Models.DAOs.IDAOs.IOsebaDAO;
import Models.Oseba;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("zrno")
@SessionScoped
public class Zrno implements Serializable, IZrno
{
    private Oseba oseba = new Oseba();
    private Aktivnost aktivnost = new Aktivnost();
    @EJB
    private IOsebaDAO osebaDAO;
    @EJB
    private IAktivnostDAO aktivnostDAO;

    public IOsebaDAO getOsebaDAO()
    {
        return osebaDAO;
    }

    @Override
    public void dodajOsebo()
    {
        Oseba copyOseba = new Oseba(oseba);
        osebaDAO.dodajOsebno(copyOseba);
        oseba = new Oseba();
    }

    @Override
    public List<Oseba> vrniVseOsebe()
    {
        return osebaDAO.vrniVse();
    }

    @Override
    public void dodajAktivnost()
    {
        Aktivnost copyAktivnost = new Aktivnost(aktivnost);
        aktivnostDAO.dodaj(copyAktivnost, osebaDAO.najdiOseboPoImenu(aktivnost.getLastnik()));
        aktivnost = new Aktivnost();
    }

    @Override
    public String vrniUrejanjePoImenu(String ime)
    {
        oseba = osebaDAO.najdiOseboPoImenu(ime);
        return "index.xhtml";
    }

    @Override
    public String vrniUrejanjePoNazivu(String naziv)
    {
        aktivnost = aktivnostDAO.najdiAktivnostPoNazivu(naziv);
        return "aktivnost.xhtml";
    }

    @Override
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

    public void setOsebaDAO(IOsebaDAO osebaDAO)
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

    public IAktivnostDAO getAktivnostDAO()
    {
        return aktivnostDAO;
    }

    public void setAktivnostDAO(IAktivnostDAO aktivnostDAO)
    {
        this.aktivnostDAO = aktivnostDAO;
    }
}
