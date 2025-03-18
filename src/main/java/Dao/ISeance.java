package Dao;

import Metier.Seance;

import java.util.List;

public interface ISeance {
    void ajouterSeance(Seance seance);
    void supprimerSeance(Long id);
    /* void modifierSeance(Long id);*/
    List<Seance> afficherListSeance();
    Seance chercherSeance(Long id);
}
