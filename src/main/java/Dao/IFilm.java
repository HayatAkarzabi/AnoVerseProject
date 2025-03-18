package Dao;

import Metier.Film;

public interface IFilm {
    void AddFilm(Film film);
    void RemoveFilm(String filmName);
    void UpdateFilm(String filmName);


}
