package Dao;

import Metier.Film;

import java.util.List;

public interface IFilm {
    void AddFilm(Film film);
    void RemoveFilm(String filmName);
    List<Film> getAllFilmsbygenre(String genre);
    List<Film> getAllFilms();
    Film getFilm(Long id);
    void UpdateFilm(Film film);
}
