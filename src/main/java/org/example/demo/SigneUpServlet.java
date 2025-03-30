package org.example.demo;

import Dao.ImplUser;
import Metier.User;
import org.mindrot.jbcrypt.BCrypt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SignUp")
public class SigneUpServlet extends HttpServlet {

    private ImplUser userDao;

    @Override
    public void init() throws ServletException {
        userDao = new ImplUser();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Vérification si l'email est déjà pris
        User existingUser = userDao.findUser(email);
        if (existingUser != null) {
            request.setAttribute("error", "Un utilisateur avec cet email existe déjà.");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            return;
        }

        // Vérification de la correspondance des mots de passe
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Les mots de passe ne correspondent pas.");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            return;
        }

        // Hachage du mot de passe et création du nouvel utilisateur
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setMotDePasse(hashedPassword);

        // Ajouter l'utilisateur à la base de données
        userDao.AddUser(newUser);

        response.sendRedirect("Login.jsp"); // Redirection après une inscription réussie
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("SignUp.jsp"); // Afficher la page de formulaire
    }
}
