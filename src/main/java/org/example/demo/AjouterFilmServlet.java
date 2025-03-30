package org.example.demo;

import Dao.ImplFilm;
import Metier.Film;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ajouterFilm")
public class AjouterFilmServlet extends HttpServlet {
    private ImplFilm filmDao;

    @Override
    public void init() throws ServletException {
        filmDao = new ImplFilm(); // Initialisation du DAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer les valeurs du formulaire
            String title = request.getParameter("title");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            String director = request.getParameter("director");
            String actors = request.getParameter("actors");
            String writer = request.getParameter("writer");

            // Vérification des champs (optionnelle)
            if (title == null || genre == null || director == null || actors == null || writer == null) {
                response.sendRedirect("error.jsp?message=Veuillez remplir tous les champs !");
                return;
            }

            // Créer un objet Film
            Film film = new Film( title, genre,  director, actors, writer,year);

            // Ajouter le film en BD
            filmDao.AddFilm(film);

            // Redirection après succès
            response.sendRedirect("confirmation.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?message=Erreur lors de l'ajout du film !");
        }
    }
}
