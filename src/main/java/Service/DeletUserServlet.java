package Service;

import Dao.ImplFilm;
import Dao.ImplUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deletUser")
public class DeletUserServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                ImplUser implUser = new ImplUser();
                implUser.DeleteUser(id);
                request.getSession().setAttribute("message", "User supprime avec succès !");
                response.sendRedirect(request.getContextPath() + "/admin/UsersAD.jsp");
            }catch (Exception e) {
                e.printStackTrace();
                request.getSession().setAttribute("message","erreur de suppression d'utilisateur");
                response.sendRedirect(request.getContextPath() + "/admin/UsersAD.jsp");
            }
        }
}
