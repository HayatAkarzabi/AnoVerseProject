package Dao;

import Metier.Place;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplIPlace implements IPlace {
    private EntityManager em;
    public ImplIPlace(){
        em= Persistence.createEntityManagerFactory("AniVerse").createEntityManager();
    }

    public void ajouterPlace(Place p) {
        em.getTransaction().begin();
        try{
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();

        }
    }
    public void supprimerPlace(Long id){
        em.getTransaction().begin();
        try{
            Place p=em.find(Place.class, id);
            em.remove(p);
        }catch(Exception e){
            em.getTransaction().rollback();
        }
    }
    public List<Place> afficherListPlace(){

        return em.createQuery("select p from Place p").getResultList();
    }


}

