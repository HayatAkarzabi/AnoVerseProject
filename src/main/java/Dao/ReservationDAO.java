package Dao;

import Metier.Reservation;
import jakarta.persistence.*;

import java.util.List;

public class ReservationDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

    public void ajouterReservation(Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(reservation);
            tx.commit();
        } finally {
            em.close();
        }
    }

    public List<Reservation> getAllReservations() {
        EntityManager em = emf.createEntityManager();
        List<Reservation> reservations = em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
        em.close();
        return reservations;
    }
}
