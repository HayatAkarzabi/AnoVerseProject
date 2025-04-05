package Service;

import java.io.IOException;

import Metier.Seance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.ImplISeance;

@WebServlet("/supprimerSeance")
public class DeleteSeanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ImplISeance seanceDao = new ImplISeance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération de l'ID de la séance à supprimer
        String seanceIdStr = request.getParameter("id");

        if (seanceIdStr == null || seanceIdStr.trim().isEmpty()) {
            // ID manquant, rediriger avec un message d'erreur
            response.sendRedirect(request.getContextPath() + "/admin/hme.jsp?error=id_missing");
            return;
        }

        try {
            // Conversion de l'ID en Long
            Long seanceId = Long.parseLong(seanceIdStr);

            // Vérifier si la séance existe avant de la supprimer
            if (seanceDao.chercherSeance(seanceId) == null) {
                response.sendRedirect(request.getContextPath() + "/admin/home.jsp?error=seance_not_found");
                return;
            }
            Seance seance = seanceDao.chercherSeance(seanceId);
            // Vérifier si la séance a des réservations
            if (!seance.getReservations().isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/admin/home.jsp?error=has_reservations");
                return;
            }

            // Suppression de la séance
            seanceDao.supprimerSeance(seanceId);

                response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
        } catch (NumberFormatException e) {
            // ID non valide
            response.sendRedirect(request.getContextPath() + "/vues/listSeances.jsp?error=invalid_id");
        } catch (Exception e) {
            // Autres erreurs
            response.sendRedirect(request.getContextPath() + "/vues/listSeances.jsp?error=system_error");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Rediriger vers la méthode doGet pour traiter la suppression
        doGet(request, response);
    }
}