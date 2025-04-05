package Dao;

import Metier.Salle;

import java.util.List;

public interface ISalle {

        void ajouterSalle(Salle salle);
        Salle rechercherSalle(Long id);
        List<Salle> afficherListSalle();
        void modifierSalle(Salle salle);
        void supprimerSalle(Long id);
    }


