package Dao;

import Metier.Film;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplFilm implements IFilm {
    private EntityManager em;
    public ImplFilm() {
        em = Persistence.createEntityManagerFactory("aniserse").createEntityManager();
    }
    @Override
    public void AddFilm(Film film) {
      em.getTransaction().begin();
    em.persist(film);
    em.getTransaction().commit();


    }

    @Override
    public void RemoveFilm(String filmName) {
        em.getTransaction().begin();
        Film film = em.createQuery("SELECT f FROM Film f WHERE f.title = :titre", Film.class)
                .setParameter("titre", filmName)
                .getSingleResult();
        if (film != null) {
            em.remove(film);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Film> getAllFilms() {
     return    em.createNativeQuery("SELECT * FROM film", Film.class).getResultList();
    }

    @Override
    public Film getFilm(Long id) {
        em.getTransaction().begin();
        return em.find(Film.class, id);
    }


    @Override
    public  void UpdateFilm(Film film) {
        em.getTransaction().begin();
        Film existingFilm = em.find(Film.class, film.getId());

        if (existingFilm != null) {
            existingFilm.setTitle(film.getTitle());
            existingFilm.setGenre(film.getGenre());
            existingFilm.setYear(film.getYear());
            existingFilm.setDirector(film.getDirector());
            existingFilm.setActors(film.getActors());
            existingFilm.setWriter(film.getWriter());

            em.merge(existingFilm); // Mettre à jour l'entité
        }

        em.getTransaction().commit();
    }








}
