package Dao;

import Metier.Film;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ImplFilm implements IFilm {
    private EntityManager em;
    public ImplFilm() {
        em = Persistence.createEntityManagerFactory("demo").createEntityManager();
    }
    @Override
    public void AddFilm(Film film) {

    }

    @Override
    public void RemoveFilm(String filmName) {

    }

    @Override
    public void UpdateFilm(String filmName) {

    }
}
