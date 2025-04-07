package Dao;

import Metier.Salle;
import Metier.Seance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
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


    public List<Seance> getSeancesByFilmId(long filmId) {
        em.getTransaction().begin();
        List<Seance> seances = null;
        try {
            // Requête pour récupérer les séances liées au film
            seances = em.createQuery("select s from Seance s where s.film.id = :filmId", Seance.class)
                    .setParameter("filmId", filmId)
                    .getResultList();


            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        return seances;
    }


    public Salle getSalleBySeance(Long seanceId) {
        Seance seance = em.find(Seance.class, seanceId);
        if (seance != null) {
            return seance.getSalle();  // Retourne la salle associée à la séance
        }
        return null;  // Si la séance n'est pas trouvée
    }
}
