package Zrna;

import Models.Aktivnost;
import Models.Oseba;

import java.util.List;

public interface IZrno
{
    void dodajOsebo();

    List<Oseba> vrniVseOsebe();

    void dodajAktivnost();

    String vrniUrejanjePoImenu(String ime);

    String vrniUrejanjePoNazivu(String naziv);

    List<Aktivnost> vrniVseAktivnosti();

    Aktivnost podvoji(String aktivnost);
}
