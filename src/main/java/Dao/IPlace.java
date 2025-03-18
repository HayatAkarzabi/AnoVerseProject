package Dao;

import Metier.Place;

import java.util.List;

public interface IPlace {
    void ajouterPlace(Place P);
    void supprimerPlace(Long id);
    List<Place> afficherListPlace();
    /*void modifierPlace(Long id);*/
}
