package Dao;

import Metier.Film;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplFilm implements IFilm {
    private EntityManager em;
    public ImplFilm() {
        em = Persistence.createEntityManagerFactory("aniverse").createEntityManager();
    }
    @Override
    public void AddFilm(Film film) {
        em.getTransaction().begin();
        em.persist(film);

    }

    @Override
    public void RemoveFilm(String filmName) {
        em.getTransaction().begin();
        Film film = em.find(Film.class, filmName);
        em.remove(film);

    }

    @Override
    public List<Film> getAllFilms() {
      return  em.createNativeQuery("SELECT * FROM Film", Film.class).getResultList();
    }

    @Override
    public Film getFilm(Long id) {
       em.getTransaction().begin();
       return em.find(Film.class, id);
    }

    @Override

    public void UpdateFilm(Film film) {
        em.getTransaction().begin();
        Film existingFilm = em.find(Film.class, film.getId());

        if (existingFilm != null) {
            existingFilm.setTitle(film.getTitle());
            existingFilm.setGenre(film.getGenre());
            existingFilm.setYear(film.getYear());
            existingFilm.setDirector(film.getDirector());
            existingFilm.setActors(film.getActors());
            existingFilm.setWriter(film.getWriter());

            em.merge(existingFilm); // Mise à jour de l'entité
        }

        em.getTransaction().commit(); // Valider la transaction
    }



}
