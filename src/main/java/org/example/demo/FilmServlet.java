package org.example.demo;/*package org.example.demo;

import Dao.ImplFilm;
import Metier.Film;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/films")
public class FilmServlet extends HttpServlet {
    private ImplFilm filmDao;

<<<<<<< Updated upstream
    @Override
    public void init() throws ServletException {
        filmDao = new ImplFilm();
=======
    static {
        films.add(new Film( "Sci-Fi", "Christopher Nolan",  "Christopher Nolan"));
        films.add(new Film(2, "Interstellar", "Sci-Fi", 2014, "Christopher Nolan", "Matthew McConaughey", "Jonathan Nolan"));
>>>>>>> Stashed changes
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            // Afficher la liste des films
            List<Film> films = filmDao.getAllFilms();
            request.setAttribute("films", films);
            request.getRequestDispatcher("films.jsp").forward(request, response);

        } else if (action.equals("details")) {
            // Afficher les détails d’un film
            long id = Long.parseLong(request.getParameter("id"));
            Film film = filmDao.getFilm(id);
            request.setAttribute("film", film);
            request.getRequestDispatcher("detailsFilm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Film film = filmDao.getFilm(id);

        if (film != null) {
            if (request.getParameter("title") != null) film.setTitle(request.getParameter("title"));
            if (request.getParameter("genre") != null) film.setGenre(request.getParameter("genre"));
            if (request.getParameter("year") != null) film.setYear(Integer.parseInt(request.getParameter("year")));
            if (request.getParameter("director") != null) film.setDirector(request.getParameter("director"));
            if (request.getParameter("actors") != null) film.setActors(request.getParameter("actors"));
            if (request.getParameter("writer") != null) film.setWriter(request.getParameter("writer"));

            filmDao.UpdateFilm(film);
        }

        response.sendRedirect("films?action=list");
    }
}

 */


import static org.junit.Assert.assertEquals;

class CalculatriceTest {
    @org.testng.annotations.Test
    void testAddition() {
        assertEquals(5, 2 + 3);
    }
}
