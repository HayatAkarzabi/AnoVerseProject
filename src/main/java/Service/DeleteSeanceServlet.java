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
            request.getSession().setAttribute("message","ID  invalide !");
                    response.sendRedirect(request.getContextPath() + "/admin/SeancesAD.jsp");
            return;
        }

        try {
            // Conversion de l'ID en Long
            Long seanceId = Long.parseLong(seanceIdStr);

            // Vérifier si la séance existe avant de la supprimer
            if (seanceDao.chercherSeance(seanceId) == null) {
                request.getSession().setAttribute("message","seance not found !");
                        response.sendRedirect(request.getContextPath() + "/admin/SeancesAD.jsp");
                return;
            }
            Seance seance = seanceDao.chercherSeance(seanceId);
            // Vérifier si la séance a des réservations
            if (!seance.getReservations().isEmpty()) {
                request.getSession().setAttribute("message","has reservations");
                        response.sendRedirect(request.getContextPath() + "/admin/SeancesAD.jsp");
                return;
            }

            // Suppression de la séance
            seanceDao.supprimerSeance(seanceId);
            request.getSession().setAttribute("message","Seance supprimee avec succès!");
                    response.sendRedirect(request.getContextPath() + "/admin/SeancesAD.jsp");
        } catch (NumberFormatException e) {
            // ID non valide
            request.getSession().setAttribute("message","ID  invalide !");
                    response.sendRedirect(request.getContextPath() + "/admin/SeancesAD.jsp");
        } catch (Exception e) {
            // Autres erreurs
            request.getSession().setAttribute("message","system error !");
                    response.sendRedirect(request.getContextPath() + "/admin/SeancesAD.jsp");
        }
    }

}