package Dao;

import Metier.Paiement;

import java.util.List;

public interface IPaiement {
    void ajouterPaiement (Paiement p);
    void supprimerPaiement (Long id );
    /*void modifierPaiement (Long id);*/
    List<Paiement> afficherListPaiement();
}
