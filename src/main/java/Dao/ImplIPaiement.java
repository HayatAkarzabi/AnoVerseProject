package Dao;

import Metier.Paiement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplIPaiement implements IPaiement {
    private EntityManager em;
    public ImplIPaiement (){
        em= Persistence.createEntityManagerFactory("aniverse").createEntityManager();
    }
    @Override
    public void ajouterPaiement(Paiement p) {
        em.getTransaction().begin();
        try{
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();

        }
    }
    public void supprimerPaiement(Long id){
        em.getTransaction().begin();
        try{
            Paiement p=em.find(Paiement.class, id);
            em.remove(p);
        }catch(Exception e){
            em.getTransaction().rollback();
        }
    }
    public List<Paiement> afficherListPaiement(){
        return em.createQuery("select p from Paiement p").getResultList();
    }


}

