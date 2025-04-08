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
        long filmId = Integer.parseInt(request.getParameter("Id")); // Récupère l'ID du film


        ImplFilm filmDAO = new ImplFilm();
        Film film = filmDAO.getFilm(filmId);

        request.setAttribute("film", film);
        request.getRequestDispatcher("Description.jsp").forward(request, response);

        System.out.println("ID reçu : " + request.getParameter("Id"));

        if (film == null) {
            System.out.println("Film non trouvé pour l'ID : " + filmId);
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Film non trouvé !");
            return;
        } else {
            System.out.println("Film trouvé : " + film.getTitle());
        }


    }

}

