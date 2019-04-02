package Models;

import Interfaces.IOpazovalec;
import Interfaces.IOpzaovaniDel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table
public class Aktivnost implements Serializable, IOpzaovaniDel
{
    @Id
    @GeneratedValue
    private int id;
    private String naziv;
    private double km;
    private Date datumAktivnosti;
    private String lastnik;

    @ManyToOne
    private Oseba osebaLastnik;

    public Aktivnost()
    {
    }

    public Aktivnost(Aktivnost aktivnost)
    {
        this.naziv = aktivnost.naziv;
        this.km = aktivnost.km;
        this.datumAktivnosti = aktivnost.datumAktivnosti;
        this.lastnik = aktivnost.lastnik;
        this.osebaLastnik = aktivnost.osebaLastnik;
    }

    @Override
    public String toString()
    {
        return "Aktivnost{" +
                "naziv='" + naziv + '\'' +
                ", km=" + km +
                ", datumAktivnosti=" + datumAktivnosti +
                ", lastnik='" + lastnik + '\'' +
                '}';
    }



    @Override
    public void prijavi(IOpazovalec o)
    {
        opazovalci.add(o);
    }

    @Override
    public void odjavi(IOpazovalec o)
    {
        opazovalci.remove(o);
    }

    @Override
    public void obvesti()
    {
        System.out.println(String.format("Kličem update"));
        for (IOpazovalec obs:
             opazovalci)
        {
            obs.posodobi(osebaLastnik, this);
        }
    }

    public String getNaziv()
    {
        return naziv;
    }

    public void setNaziv(String naziv)
    {
        this.naziv = naziv;
    }

    public double getKm()
    {
        return km;
    }

    public void setKm(double km)
    {
        this.km = km;
    }

    public Date getDatumAktivnosti()
    {
        return datumAktivnosti;
    }

    public void setDatumAktivnosti(Date datumAktivnosti)
    {
        this.datumAktivnosti = datumAktivnosti;
    }

    public String getLastnik()
    {
        return lastnik;
    }

    public void setLastnik(String lastnik)
    {
        this.lastnik = lastnik;
    }

    public ArrayList<IOpazovalec> getOpazovalci()
    {
        return opazovalci;
    }

    public Oseba getOsebaLastnik()
    {
        return osebaLastnik;
    }

    public void setOsebaLastnik(Oseba osebaLastnik)
    {
        this.osebaLastnik = osebaLastnik;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
