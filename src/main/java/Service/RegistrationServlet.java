package Service;

import Dao.ImplUser;
import Metier.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
    private ImplUser userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        userDao = new ImplUser(); // Initialisation du DAO
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les paramètres du formulaire
        String email = request.getParameter("email");
        String motDePasse = request.getParameter("password");
        String motDePasseConfirmation = request.getParameter("checkInputPassword");

        // Vérification de la correspondance des mots de passe
        if (!motDePasse.equals(motDePasseConfirmation)) {
            request.setAttribute("error", "Les mots de passe ne correspondent pas.");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }

        // Vérification si l'email existe déjà
        User existingUser = userDao.findUser(email);
        if (existingUser != null) {
            request.setAttribute("error", "Cet email est déjà utilisé.");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }

        // Créer un nouvel utilisateur
        try {
            User newUser = new User(email, motDePasse,"client");

            // Utiliser la méthode AddUser de ImplUser pour ajouter l'utilisateur à la base de données
            userDao.AddUser(newUser);

            // Redirection vers la page de connexion après l'ajout
            response.sendRedirect("Login.jsp");

        } catch (Exception e) {
            // Gérer l'exception et retourner un message d'erreur
            e.printStackTrace();
            request.setAttribute("error", "Une erreur est survenue lors de la création de l'utilisateur.");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
