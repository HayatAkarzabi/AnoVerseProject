package Dao;

import Metier.Salle;
import Metier.Seance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImplISalle implements ISalle {
    private EntityManager em;
    public ImplISalle() {
        em= Persistence.createEntityManagerFactory("aniverse").createEntityManager();
    }
    public void ajouterSalle(Salle salle) {
        em.getTransaction().begin();
        try{
            em.persist(salle);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
    }
    public Salle rechercherSalle(Long id){
        em.getTransaction().begin();
        try{
            Salle salle = em.find(Salle.class, id);
            em.getTransaction().commit();
            return salle;
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        return null;

    }
    public List<Salle> afficherListSalle() {
        return em.createQuery("SELECT s FROM Salle s", Salle.class).getResultList();
    }

    public void modifierSalle(Salle salle) {
        try {
            em.getTransaction().begin();
            em.merge(salle);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void supprimerSalle(Long id) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Salle.class, id));
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public int getPlacesReservees(Long salleId) {
        String jpql = "SELECT COUNT(p) FROM Place p WHERE p.salle.id = :salleId AND p.estResrvee = true";
        TypedQuery<Long> query = em.createQuery(jpql, Long.class);
        query.setParameter("salleId", salleId);
        Long count = query.getSingleResult();
        return count.intValue();  // Retourne le nombre de places réservées
    }
}
