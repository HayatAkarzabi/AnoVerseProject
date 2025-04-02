package Service;

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

    @Override
    public void init() throws ServletException {
        filmDao = new ImplFilm();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.equals("list")) {
            List<Film> films = filmDao.getAllFilms();
            request.setAttribute("films", films);
            request.getRequestDispatcher("films.jsp").forward(request, response);
        } else if (action.equals("details")) {
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
            if (request.getParameter("description") != null) film.setDiscription(request.getParameter("description"));
            if (request.getParameter("photo") != null) film.setPhoto(request.getParameter("photo"));

            filmDao.UpdateFilm(film);
        }

        response.sendRedirect("films?action=list");
    }
}
