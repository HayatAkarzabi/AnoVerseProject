package Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.ImplFilm;
import Dao.ImplISalle;
import Dao.ImplISeance;
import Metier.Film;
import Metier.Salle;
import Metier.Seance;

@WebServlet("/addSeance")
public class AddSeanceServlet extends HttpServlet {

    private ImplISeance seanceDao = new ImplISeance();
    private ImplFilm filmDao = new ImplFilm();
    private ImplISalle salleDao = new ImplISalle();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Récupération des paramètres du formulaire
            String filmIdStr = request.getParameter("filmId");
            String salleIdStr = request.getParameter("salleId");
            String seanceDateStr = request.getParameter("seanceDate");
            String seanceTimeStr = request.getParameter("seanceTime");

            // Validation des données
            if (filmIdStr == null || filmIdStr.trim().isEmpty() ||
                    salleIdStr == null || salleIdStr.trim().isEmpty() ||
                    seanceDateStr == null || seanceDateStr.trim().isEmpty() ||
                    seanceTimeStr == null || seanceTimeStr.trim().isEmpty()) {

                request.setAttribute("error", "Tous les champs sont obligatoires");
                request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
                return;
            }

            // Conversion des identifiants
            Long filmId = Long.parseLong(filmIdStr);
            Long salleId = Long.parseLong(salleIdStr);

            // Récupération des objets Film et Salle
            Film film = filmDao.getFilm(filmId);
            Salle salle = salleDao.rechercherSalle(salleId);

            if (film == null || salle == null) {
                request.setAttribute("error", "Film ou salle introuvable");
                request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
                return;
            }

            // Conversion et combinaison de la date et l'heure
            LocalDate date = LocalDate.parse(seanceDateStr);
            LocalTime time = LocalTime.parse(seanceTimeStr);
            LocalDateTime dateTime = LocalDateTime.of(date, time);

//            // Vérification des conflits de séances dans la même salle
//            if (seanceDao.hasConflictingSeance(salleId, dateTime)) {
//                request.setAttribute("error", "Une séance est déjà programmée dans cette salle à cette date et heure");
//                request.getRequestDispatcher("/admine/home.jsp").forward(request, response);
//                return;
//            }

            // Création de lmvn package'objet Seance
            Seance seance = new Seance();
            seance.setFilm(film);
            seance.setSalle(salle);
            seance.setDate(dateTime);

            // Sauvegarde de la séance
            seanceDao.ajouterSeance(seance);
            request.getSession().setAttribute("message","Seance ajoutee avec succes");
            response.sendRedirect(request.getContextPath() + "/admin/SeancesAD.jsp");
        } catch (NumberFormatException e) {
            request.getSession().setAttribute("message", "Format de numéro invalide");
            request.getRequestDispatcher("/admin/SeancesAD.jsp").forward(request, response);
        } catch (DateTimeParseException e) {
            request.getSession().setAttribute("message", "Format de date ou d'heure invalide");
            request.getRequestDispatcher("/admin/SeancesAD.jsp").forward(request, response);
        } catch (Exception e) {
            request.getSession().setAttribute("message",  "Une erreur est survenue: " + e.getMessage());
            request.getRequestDispatcher("/admin/SeancesAD.jsp").forward(request, response);
        }
    }
}