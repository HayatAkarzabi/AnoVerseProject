package org.example.demo;

import Metier.Film;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "films" , value = "/films")
public class FilmServlet extends HttpServlet {
    private static final List<Film> films = new ArrayList<>();

    static {
        films.add(new Film(1, "Inception", "Sci-Fi", 2010, "Christopher Nolan", "Leonardo DiCaprio", "Christopher Nolan"));
        films.add(new Film(2, "Interstellar", "Sci-Fi", 2014, "Christopher Nolan", "Matthew McConaughey", "Jonathan Nolan"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("films", films);
        request.getRequestDispatcher("films.jsp").forward(request, response);
    }
}
