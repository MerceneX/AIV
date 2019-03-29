package Models.DAOs.IDAOs;

import Models.Oseba;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IOsebaDAO
{
    void dodajOsebno(Oseba oseba);

    List<Oseba> vrniVse();

    Oseba najdiOseboPoImenu(String ime);

    void posodobiOsebo(Oseba staraOseba, Oseba novaOseba);
}
