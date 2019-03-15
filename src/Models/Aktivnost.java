package Models;

import java.util.Date;

public class Aktivnost
{
    private String naziv;
    private double km;
    private Date datumAktivnosti;
    private String lastnik;

    public Aktivnost()
    {
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

    public Aktivnost(String naziv, double km, Date datumAktivnosti)
    {
        this.naziv = naziv;
        this.km = km;
        this.datumAktivnosti = datumAktivnosti;
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

}
