package Service;

import Dao.ImplUser;
import Metier.User;
import jakarta.jws.WebService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.ws.WebServiceProvider;

import java.io.IOException;
@WebServlet("/addUser")
public class addUserSevlet extends HttpServlet {
    private ImplUser userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new ImplUser(); // Initialisation du DAO
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("checkInputPassword");
        String role = request.getParameter("role");
        if (email == null || role == null || password == null || confirmPassword == null ||
                email.isEmpty() || role.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            request.getSession().setAttribute("message",  "Veuillez remplir tous les champs !");
            request.getRequestDispatcher("/admin/addUser.jsp").forward(request, response);
            return;
        }
        if (!password.equals(confirmPassword)) {
            request.getSession().setAttribute("message", "Les mots de passe ne correspondent pas !");
            request.getRequestDispatcher("/admin/addUser.jsp").forward(request, response);
            return;
        }
        try {
            User user = new User(email, password, role);
            userDao.AddUser(user);
            request.getSession().setAttribute("message","Utilisateur ajoute avec succès");
                    response.sendRedirect(request.getContextPath() + "/admin/UsersAD.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("message", "Erreur lors de l'ajout de l'utilisateur !");
            request.getRequestDispatcher("/admin/UsersAD.jsp").forward(request, response);
        }
    }
}
