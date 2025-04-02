package org.example.demo;

import Dao.ImplIReservation;
import Metier.Reservation;
import Metier.Seance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/reservations")
public class ReservationServlet extends HttpServlet {
    private ImplIReservation reservationDAO;

    @Override
    public void init() throws ServletException {
        reservationDAO = new ImplIReservation();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer les paramètres du formulaire
            String film = request.getParameter("film");
            String status = request.getParameter("status");
            String description = request.getParameter("description");
            String location = request.getParameter("location");

            // Créer une nouvelle réservation
            Reservation reservation = new Reservation();
           reservation.setDateReservation(new Date());
           reservation.setSeance(new Seance());

            // Ajouter la réservation à la base de données
            reservationDAO.ajouterReservation(reservation);

            // Redirection vers la liste des réservations
            response.sendRedirect("reservations");
        } catch (Exception e) {
            throw new ServletException("Erreur lors de l'ajout d'une réservation", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer toutes les réservations
            List<Reservation> reservations = reservationDAO.getAllReservations();

            // Stocker la liste dans l'objet request pour l'afficher sur la page JSP
            request.setAttribute("reservations", reservations);

            // Transférer à la page JSP
            request.getRequestDispatcher("reservations.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erreur lors de la récupération des réservations", e);
        }
    }
}
