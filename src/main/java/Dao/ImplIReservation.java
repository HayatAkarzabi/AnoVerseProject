package Dao;

import Metier.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplIReservation implements IReservation {
    private EntityManager em;
    public ImplIReservation() {
        em= Persistence.createEntityManagerFactory("aniverse").createEntityManager();
    }
    public void ajouterReservation(Reservation r) {
        em.getTransaction().begin();
        try{
            em.persist(r);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public void annulerReservation(Long id) {
        em.getTransaction().begin();
        try{
            Reservation r = em.find(Reservation.class, id);
            em.remove(r);
        }catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public Reservation RechercherReservation(Long id) {
        em.getTransaction().begin();
        try{
            Reservation r = em.find(Reservation.class, id);
            return r;
        }catch (Exception e) {
            em.getTransaction().rollback();
        }
        return null;
    }
    public   List<Reservation> afficherTousReservations(){
        return em.createNativeQuery("select  * from Reservation ").getResultList();

    }

    public List<Reservation> getAllReservations() {
        return em.createNativeQuery("select * from Reservation ").getResultList();
    }
}
