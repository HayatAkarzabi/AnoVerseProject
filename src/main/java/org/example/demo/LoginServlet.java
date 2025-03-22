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

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private ImplUser userDao;

    @Override
    public void init() throws ServletException {
        userDao = new ImplUser();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Email saisi : " + email);
        System.out.println("Mot de passe saisi : " + password);

        // Recherche de l'utilisateur dans la base de données
        User user = userDao.findUser(email);

        if (user != null) {
            System.out.println("Utilisateur trouvé : " + user.getEmail());
            System.out.println("Mot de passe haché : " + user.getMotDePasse());

            // Vérification du mot de passe
            if (BCrypt.checkpw(password, user.getMotDePasse())) {
                // Création de la session utilisateur
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // Redirection en fonction du rôle
                if ("admin".equalsIgnoreCase(user.getRole())) {
                    response.sendRedirect("admin/home.jsp");
                } else {
                    response.sendRedirect("userDashboard.jsp");
                }
                return;
            } else {
                System.out.println("Mot de passe incorrect.");
            }
        } else {
            System.out.println("Aucun utilisateur trouvé pour cet email.");
        }

        // Échec de l'authentification
        request.setAttribute("error", "Email ou mot de passe incorrect");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Login.jsp");
    }
}
