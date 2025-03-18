package Dao;

import Metier.Reservation;

import java.util.List;

public interface IReservation {

    void ajouterReservation(Reservation reservation);
    void annulerReservation(Long id);
    Reservation RechercherReservation(Long userId);
    List<Reservation> afficherTousReservations();



}
