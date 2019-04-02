package Models.DAOs.IDAOs;

import Models.Aktivnost;
import Models.Oseba;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IAktivnostDAO
{
    void dodaj(Aktivnost aktivnost, Oseba o);

    Aktivnost najdiAktivnostPoNazivu(String naziv);

    void posodobiAktivnost(Aktivnost stara, Aktivnost nova);

    List<Aktivnost> vrniVse();
}
