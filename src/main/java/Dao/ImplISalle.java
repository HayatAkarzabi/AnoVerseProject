package Dao;

import Metier.Salle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

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
    public List<Salle> afficherListSalle(){
        return em.createNativeQuery("select * from Salle").getResultList();

    }

}
