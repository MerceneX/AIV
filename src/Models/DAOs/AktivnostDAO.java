package Models.DAOs;

import Mailman.Logger;
import Mailman.Vrsta;
import Models.Aktivnost;
import Models.Oseba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AktivnostDAO implements Models.DAOs.IDAOs.IAktivnostDAO
{
    private ArrayList<Aktivnost> aktivnosti = new ArrayList<>();
    @PersistenceContext
    private EntityManager em;

    public AktivnostDAO()
    {
    }

    @Override
    public void dodaj(Aktivnost aktivnost, Oseba o)
    {
        Aktivnost najdenaAktivnost = najdiAktivnostPoNazivu(aktivnost.getNaziv());
        if (najdenaAktivnost == null)
        {
            aktivnost.setOsebaLastnik(o);
            Aktivnost copyAktivnost = new Aktivnost(aktivnost);
            //Email mail = new Email();
            //copyAktivnost.prijavi(mail);
            copyAktivnost.prijavi( new Logger());
            copyAktivnost.prijavi(new Vrsta());
            aktivnosti.add(copyAktivnost);
            copyAktivnost.obvesti();
            em.persist(copyAktivnost);

        } else
        {
            posodobiAktivnost(najdenaAktivnost, aktivnost);
            em.merge(najdenaAktivnost);
        }
    }

    @Override
    public Aktivnost najdiAktivnostPoNazivu(String naziv)
    {
        Aktivnost akt;
        try
        {
            akt = (Aktivnost)em.createQuery("SELECT a from Aktivnost a Where a.naziv=?1").setParameter(1,naziv).getSingleResult();
            return akt;
        }catch (Exception e)
        {
            System.out.println("Napaka pri iskanju \n"+e);
            return null;
        }
    }

    @Override
    public void posodobiAktivnost(Aktivnost stara, Aktivnost nova){
        stara.setKm(nova.getKm());
        stara.setDatumAktivnosti(nova.getDatumAktivnosti());
        stara.setLastnik(nova.getLastnik());
        nova.obvesti();
    }

    @Override
    public List<Aktivnost> vrniVse()
    {
        return (List<Aktivnost>) em.createQuery("SELECT a from Aktivnost a").getResultList();
    }


}
