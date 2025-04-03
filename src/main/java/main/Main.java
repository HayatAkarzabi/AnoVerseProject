package main;

import Dao.*;
import Metier.Film;
import Metier.Reservation;
import Metier.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IUser dao = new ImplUser();
        ImplFilm film =  new ImplFilm();

        film.AddFilm(new Film("solo leveling","musuke",2019,"tensei","akatuski","musuke","description de notre film sololeveling","Images/sololeveling.jpg"));
        film.AddFilm(new Film("Naruto","hotchinasazi",2003,"diector3","sasuke madara","writer2","nine tails monster ","Images/hunterXhunter.jpg"));
        dao.AddUser(new User("nouhayousse@gmail.com","jjk7","admin"));
        dao.AddUser(new User("hayat@gmail.com","1234"));
        dao.AddUser(new User("imane@gmail.com","12345"));
        dao.AddUser(new User("layla@gmail.com","12346"));
        dao.AddUser(new User("wissal@gmail.com","12347"));


    }
}
