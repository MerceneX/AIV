package Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Oseba implements Serializable
{


    @Override
    public String toString()
    {
        return String.format("Ime: %s, Priimek: %s, Spol: %s, Datum Rojstva: %tD, Telesna teža: %f, Telesna višina: %f, E-Mail: %s", this.ime, this.priimek, this.spol, this.datumRojstva, this.telesnaTeza, this.telesnaVisina, this.email);
    }
    private String ime;
    private String priimek;
    private String spol;
    private Date datumRojstva;
    private double telesnaTeza;
    private double telesnaVisina;
    @Id
    private String email;

    public Oseba(String ime, String priimek, String spol, Date datumRojstva, double telesnaTeza, double telesnaVisina, String email)
    {
        this.ime = ime;
        this.priimek = priimek;
        this.spol = spol;
        this.datumRojstva = datumRojstva;
        this.telesnaTeza = telesnaTeza;
        this.telesnaVisina = telesnaVisina;
        this.email = email;
    }

    public Oseba(Oseba oseba){
        this.ime = oseba.ime;
        this.priimek = oseba.priimek;
        this.spol = oseba.spol;
        this.datumRojstva = oseba.datumRojstva;
        this.telesnaTeza = oseba.telesnaTeza;
        this.telesnaVisina = oseba.telesnaVisina;
        this.email = oseba.email;
    }

    public Oseba()
    {

    }

    public String getIme()
    {
        return ime;
    }

    public void setIme(String ime)
    {
        this.ime = ime;
    }

    public String getPriimek()
    {
        return priimek;
    }

    public void setPriimek(String priimek)
    {
        this.priimek = priimek;
    }

    public String getSpol()
    {
        return spol;
    }

    public void setSpol(String spol)
    {
        this.spol = spol;
    }

    public Date getDatumRojstva()
    {
        return datumRojstva;
    }

    public void setDatumRojstva(Date datumRojstva)
    {
        this.datumRojstva = datumRojstva;
    }

    public double getTelesnaTeza()
    {
        return telesnaTeza;
    }

    public void setTelesnaTeza(double telesnaTeza)
    {
        this.telesnaTeza = telesnaTeza;
    }

    public double getTelesnaVisina()
    {
        return telesnaVisina;
    }

    public void setTelesnaVisina(double telesnaVisina)
    {
        this.telesnaVisina = telesnaVisina;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


}
