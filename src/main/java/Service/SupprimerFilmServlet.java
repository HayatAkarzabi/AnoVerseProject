package Service;

import Dao.ImplFilm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/supprimerFilm")
public class SupprimerFilmServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            ImplFilm implFilm = new ImplFilm();
            implFilm.RemoveFilm(id);
            request.getSession().setAttribute("message", "Film supprime avec succès !");
            response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
