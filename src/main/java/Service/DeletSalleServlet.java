package Service;
import Metier.Salle;
import Dao.ImplISalle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/supprimerSalle")
public class DeletSalleServlet extends HttpServlet {

    private ImplISalle implISalle;

    @Override
    public void init() throws ServletException {
        implISalle = new ImplISalle();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer l'ID de la salle à partir des paramètres de la requête
            Long salleId = Long.parseLong(request.getParameter("id"));

            // Rechercher la salle par son ID
            Salle salle = implISalle.rechercherSalle(salleId);
            if (salle == null) {
                request.setAttribute("error", "Salle non trouvée !");
                request.getRequestDispatcher("/admin/listeSalles.jsp").forward(request, response);
                return;
            }

            // Supprimer la salle
            implISalle.supprimerSalle(salleId);

            // Rediriger vers la liste des salles après suppression
            response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
        } catch (Exception e) {
            request.setAttribute("error", "Erreur lors de la suppression de la salle !");
            request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
        }
    }
}

