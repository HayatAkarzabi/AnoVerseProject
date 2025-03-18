package main;

import Dao.*;
import Metier.Film;
import Metier.Reservation;
import Metier.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        IUser dao = new ImplUser();
        IFilm film =  new ImplFilm();

        dao.AddUser(new User("Hayat","1234"));


    }
}
