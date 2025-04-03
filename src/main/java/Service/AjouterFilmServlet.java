package Service;

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
        filmDao = new ImplFilm();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            String director = request.getParameter("director");
            String actors = request.getParameter("actors");
            String writer = request.getParameter("writer");
            String description = request.getParameter("description");
            String photo = request.getParameter("photo");

            if (title == null || genre == null || director == null || actors == null || writer == null || description == null || photo == null) {
                response.sendRedirect("error.jsp?message=Veuillez remplir tous les champs !");
                return;
            }

            Film film = new Film(title, genre, year, actors, writer, description, director, photo);

            filmDao.AddFilm(film);

            response.sendRedirect("confirmation.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp?message=Erreur lors de l'ajout du film !");
        }
    }
}
