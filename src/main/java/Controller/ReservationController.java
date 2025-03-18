//package Controller;
//
//import Metier.Reservation;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Contrôleur REST pour gérer les réservations.
// * Utilise JAX-RS pour exposer des API accessibles via HTTP.
// */
//@Path("/reservations") // L'URL de base de l'API sera "/reservations"
//@Produces(MediaType.APPLICATION_JSON) // Toutes les réponses seront en format JSON
//@Consumes(MediaType.APPLICATION_JSON) // Les données reçues (POST) seront en format JSON
//public class ReservationController {
//
//    /**
//     * Stockage temporaire des réservations (⚠ à remplacer par une base de données)
//     */
//    private static List<Reservation> reservations = new ArrayList<>();
//
//    /**
//     * Récupère la liste de toutes les réservations.
//     *
//     * @return une réponse HTTP contenant la liste des réservations en JSON.
//     */
//    @GET
//    public Response getReservations() {
//        return Response.ok(reservations).build(); // 200 OK avec la liste des réservations
//    }
//
//    /**
//     * Ajoute une nouvelle réservation.
//     *
//     * @param reservation L'objet Reservation envoyé en JSON dans la requête.
//     * @return une réponse HTTP 201 CREATED contenant la réservation ajoutée.
//     */
//    @POST
//    public Response addReservation(Reservation reservation) {
//        reservations.add(reservation); // Ajout de la réservation à la liste
//        return Response.status(Response.Status.CREATED) // 201 Created
//                .entity(reservation) // Retourner la réservation ajoutée
//                .build();
//    }
//
//    /**
//     * Supprime une réservation par son ID.
//     *
//     * @param id L'index de la réservation à supprimer (⚠ basé sur la position dans la liste).
//     * @return une réponse HTTP :
//     *         - 204 NO CONTENT si la suppression est réussie.
//     *         - 404 NOT FOUND si l'ID est invalide.
//     */
//    @DELETE
//    @Path("/{id}") // {id} est un paramètre dynamique dans l'URL (ex: /reservations/1)
//    public Response removeReservation(@PathParam("id") int id) {
//        if (id < 0 || id >= reservations.size()) { // Vérifier si l'ID est valide
//            return Response.status(Response.Status.NOT_FOUND) // 404 Not Found
//                    .entity("Reservation avec ID " + id + " introuvable.") // Message d'erreur
//                    .build();
//        }
//        reservations.remove(id); // Supprimer la réservation
//        return Response.status(Response.Status.NO_CONTENT).build(); // 204 No Content (pas de corps de réponse)
//    }
//}
