package Models.DAOs;

import Models.Oseba;

import java.util.ArrayList;

public class OsebaDAO
{
    private ArrayList<Oseba> osebe = new ArrayList<>();

    private OsebaDAO()
    {
    }

    private static OsebaDAO edinec = new OsebaDAO();

    public static OsebaDAO getInstance()
    {
        return edinec;
    }

    public void dodajOsebno(Oseba oseba)
    {
        Oseba najdenaOseba = najdiOseboPoImenu(oseba.getIme());
        if (najdenaOseba == null)
        {
            osebe.add(oseba);
        } else
        {
            posodobiOsebo(najdenaOseba, oseba);
        }
    }

    public ArrayList<Oseba> vrniVse()
    {
        return osebe;
    }

    public Oseba najdiOseboPoImenu(String ime)
    {
        for (Oseba o :
                osebe)
        {
            if (o.getIme().equals(ime))
            {
                return o;
            }
        }
        return null;
    }

    public void posodobiOsebo(Oseba staraOseba, Oseba novaOseba)
    {
        staraOseba.setPriimek(novaOseba.getPriimek());
        staraOseba.setDatumRojstva(novaOseba.getDatumRojstva());
        staraOseba.setEmail(novaOseba.getEmail());
        staraOseba.setSpol(novaOseba.getSpol());
        staraOseba.setTelesnaTeza(novaOseba.getTelesnaTeza());
        staraOseba.setTelesnaVisina(novaOseba.getTelesnaVisina());
    }
}
