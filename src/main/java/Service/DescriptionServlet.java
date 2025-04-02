package Service;

import Dao.ImplFilm;
import Metier.Film;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/description")
public class DescriptionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long filmId = Integer.parseInt(request.getParameter("filmId")); // Récupère l'ID du film


        ImplFilm filmDAO = new ImplFilm();
        Film film = filmDAO.getFilm(filmId);

        request.setAttribute("film", film);
        request.getRequestDispatcher("Description.jsp").forward(request, response);
    }
}

