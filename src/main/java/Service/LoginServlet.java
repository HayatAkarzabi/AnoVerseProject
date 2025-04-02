package Service;

import Dao.ImplUser;
import Metier.User;
import org.mindrot.jbcrypt.BCrypt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    private ImplUser userDao;


    @Override
    public void init() throws ServletException {
        try {
            // Try to load the driver class explicitly
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL driver loaded successfully");

            userDao = new ImplUser();
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL driver not found: " + e.getMessage());
            throw new ServletException("MySQL driver not found", e);
        } catch (Exception e) {
            System.err.println("Error initializing servlet: " + e.getMessage());
            e.printStackTrace();
            throw new ServletException("Failed to initialize UserDAO", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
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

}
