package Service;

import Dao.ImplIReservation;
import Dao.ImplISalle;
import Dao.ImplISeance;
import Metier.Reservation;
import Metier.Salle;
import Metier.Seance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/validerReservation")
public class ValiderReservationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        Long seanceId = Long.parseLong(request.getParameter("seanceId"));
        int nbPlaces = Integer.parseInt(request.getParameter("nbPlaces"));

        ImplISeance seanceDAO = new ImplISeance();
        ImplISalle salleDAO = new ImplISalle();
        ImplIReservation reservationDAO = new ImplIReservation();


        Seance seance = seanceDAO.chercherSeance(seanceId);
        Salle salle = seanceDAO.getSalleBySeance(seanceId);

        // Vérification que les places sont disponibles
        int placesRestantes = salle.getCapacite() - salleDAO.getPlacesReservees(salle.getId());
        if (nbPlaces > placesRestantes) {
            request.setAttribute("message", "Nombre de places demandé indisponible !");
            request.getRequestDispatcher("Reservation.jsp").forward(request, response);
            return;
        }

        // ✨ Enregistrement de la réservation
        Reservation reservation = new Reservation();
        reservation.setSeance(seance);
        reservation.setNombrePlaces(nbPlaces);
        reservation.setDateReservation(new Date());

        try {
            reservationDAO.ajouterReservation(reservation); // Implémenter cette méthode
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erreur lors de la sauvegarde de la réservation : " + e.getMessage());
            return;
        }



        // Sauvegarde de la réservation fictive ici
        // Exemple : salleDAO.reserverPlaces(salle, nbPlaces); → implémenter dans ta DAO

        // Simulation sauvegarde (à remplacer par vraie logique)
        LocalDateTime date = seance.getDate(); // ou getDateTime()
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dateFormatee = date.format(formatter);

        request.setAttribute("dateFormatee", dateFormatee);

        request.setAttribute("film", seance.getFilm());
        request.setAttribute("nbPlaces", nbPlaces);
        request.setAttribute("salle", salle);

        request.getRequestDispatcher("confirmation.jsp").forward(request, response);
    }
}

