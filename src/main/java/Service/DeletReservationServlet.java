package Service;

import Dao.ImplIReservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AdminDeleteReservationServlet")
public class DeletReservationServlet extends HttpServlet {
    private ImplIReservation reservationDAO;

    @Override
    public void init() throws ServletException {
        super.init();
            reservationDAO = new ImplIReservation();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupération de l'ID de la réservation
            Long reservationId = Long.parseLong(request.getParameter("id"));

            // Suppression de la réservation
           reservationDAO.annulerReservation(reservationId);



        } catch (NumberFormatException e) {
            request.getSession().setAttribute("errorMessage", "ID de réservation invalide.");
        } catch (Exception e) {
            request.getSession().setAttribute("errorMessage", "Erreur lors de la suppression : " + e.getMessage());
        }

        // Redirection vers la page de gestion des réservations
        response.sendRedirect("AdminReservationsServlet");
    }
}