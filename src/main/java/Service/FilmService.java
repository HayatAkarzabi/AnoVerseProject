package Service;

import Metier.Film;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class FilmService {
    @PersistenceContext
    private EntityManager em;

    public List<Film> getAllFilms() {
        return em.createQuery("SELECT f FROM Film f", Film.class).getResultList();
    }
}

