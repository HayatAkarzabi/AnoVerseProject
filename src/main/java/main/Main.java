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

        dao.AddUser(new User("Imane@gmail.com","4444","admin"));
        dao.AddUser(new User("hayat@gmail.com","1234"));


    }
}
