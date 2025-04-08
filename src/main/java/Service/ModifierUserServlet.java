package Service;

import Dao.ImplFilm;
import Dao.ImplUser;
import Metier.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/modifierUser")
public class ModifierUserServlet extends HttpServlet {
    private ImplUser implUser;

    @Override
    public void init() throws ServletException {
        implUser = new ImplUser();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String email = request.getParameter("email");
            String role = request.getParameter("role");
            String password = request.getParameter("newpassword");


            if (email == null || email.isEmpty() || role == null || role.isEmpty() || password == null || password.isEmpty()) {
                request.getSession().setAttribute("message",  "tous les champes sont obligatoires.");
                request.getRequestDispatcher("ModifierUser.jsp?id="+id).forward(request, response);
                return;
            }

            User user = new User(id, email, role, password);
            implUser.UpdateUser(user);
            request.getSession().setAttribute("message",  "modification successful");
            response.sendRedirect(request.getContextPath() + "/admin/UsersAD.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("message", "Erreur lors de la modification du user !");
            response.sendRedirect(request.getContextPath() + "/admin/UsersAD.jsp");
        }
    }

}
