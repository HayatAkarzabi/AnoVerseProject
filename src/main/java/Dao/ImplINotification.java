package Dao;



import Metier.Notification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplINotification implements INotification {
    private EntityManager em;
    public ImplINotification() {
        em= Persistence.createEntityManagerFactory("AniVerse").createEntityManager();
    }

    public void  ajouterNotification(Notification N) {
        em.getTransaction().begin();
        try{
            em.persist(N);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();

        }
    }
    public void supprimerNotification(Long id){
        em.getTransaction().begin();
        try{
            Notification N=em.find(Notification.class, id);
            em.remove(N);
        }catch(Exception e){
            em.getTransaction().rollback();
        }
    }
    public List<Notification> afficherListNotification(){

        return em.createQuery("select N from Notification N").getResultList();
    }
}
