package Dao;

import Metier.Place;
import Metier.Salle;
import Metier.Seance;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ImplIPlace implements IPlace {
    private EntityManager em;
    public ImplIPlace(){
        em= Persistence.createEntityManagerFactory("aniverse").createEntityManager();
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
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
    }
    public List<Place> afficherListPlace(){

        return em.createQuery("select p from Place p").getResultList();
    }


    public List<Place> getPlacesDisponiblesParSeance(Long seanceId) {
        try {
            // Étape 1 : Trouver la salle associée à la séance
            String jpqlSalle = "SELECT s FROM Seance s WHERE s.id = :seanceId";
            Query querySalle = em.createQuery(jpqlSalle);
            querySalle.setParameter("seanceId", seanceId);
            Seance seance = (Seance) querySalle.getSingleResult();
            Salle salle = seance.getSalle();

            // Étape 2 : Récupérer les places non réservées de la salle
            String jpqlPlaces = "SELECT p FROM Place p WHERE p.salle.id = :salleId AND p.estResrvee = false";
            Query queryPlaces = em.createQuery(jpqlPlaces);
            queryPlaces.setParameter("salleId", salle.getId());

            // Exécution de la requête et récupération des résultats
            List<Place> placesDisponibles = queryPlaces.getResultList();
            return placesDisponibles;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Ou vous pouvez lancer une exception personnalisée
        }
    }

    public void update(Place place) {
        try {
            em.getTransaction().begin();  // Commence une transaction
            em.merge(place);             // Merge l'objet (mise à jour)
            em.getTransaction().commit(); // Commit la transaction pour sauvegarder les modifications
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Annule la transaction en cas d'erreur
            }
        }
    }
}

