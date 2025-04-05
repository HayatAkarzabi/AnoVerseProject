package Dao;

import Metier.Seance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplISeance implements ISeance {
    private EntityManager em;
    public ImplISeance(){
        em= Persistence.createEntityManagerFactory("aniverse").createEntityManager();
    }

    public void ajouterSeance(Seance S) {
        em.getTransaction().begin();
        try{
            em.persist(S);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();

        }
    }
    public void supprimerSeance(Long id){
        em.getTransaction().begin();
        try{
            Seance S=em.find(Seance.class, id);
            em.remove(S);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
    }
    public List<Seance> afficherListSeance(){

        return em.createQuery("select S from Seance S").getResultList();
    }

    public Seance chercherSeance(Long id) {
        Seance S = null;
        try {
            S = em.find(Seance.class, id);
        } catch (Exception e) {
            em.getTransaction().rollback(); // Afficher l'erreur pour comprendre le problème
        }
        return S;
    }
    public void modifierSeance(Seance S) {
        em.getTransaction().begin();
        try {
            em.merge(S);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
    }



}
