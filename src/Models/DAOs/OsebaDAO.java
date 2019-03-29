package Models.DAOs;

import Models.DAOs.IDAOs.IOsebaDAO;
import Models.Oseba;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OsebaDAO implements IOsebaDAO
{
    private List<Oseba> osebe;
    @PersistenceContext
    private EntityManager em;

    @Override
    public void dodajOsebno(Oseba oseba)
    {
        Oseba najdenaOseba = najdiOseboPoImenu(oseba.getIme());
        if (najdenaOseba == null)
        {
            em.persist(oseba);
        } else
        {
            posodobiOsebo(najdenaOseba, oseba);
            em.merge(najdenaOseba);
        }
    }

    @Override
    public List<Oseba> vrniVse()
    {
        List<Oseba> osebe = em.createQuery("SELECT o from Oseba o").getResultList();
        return osebe;
    }

    @Override
    public Oseba najdiOseboPoImenu(String ime)
    {
        Oseba oseba;
        try
        {
            oseba = (Oseba)em.createQuery("SELECT o from Oseba o Where o.ime=?1").setParameter(1,ime).getSingleResult();
            return oseba;
        }catch (Exception e){
            System.out.println("Napaka pri branju osebe\n" +e);
            return null;
        }
    }

    @Override
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
