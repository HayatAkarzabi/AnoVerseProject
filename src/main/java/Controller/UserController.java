package Controller;


import Metier.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur REST pour la gestion des utilisateurs.
 */
@Path("/users") // Nom au pluriel par convention REST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    /**
     * Stockage temporaire des utilisateurs (⚠ À remplacer par une base de données).
     */
    private static List<User> utilisateurs = new ArrayList<>();

    /**
     * Récupérer tous les utilisateurs.
     *
     * @return Une réponse HTTP contenant la liste des utilisateurs en JSON.
     */
    @GET
    public Response getUtilisateurs() {
        return Response.ok(utilisateurs).build(); // 200 OK avec la liste
    }

    /**
     * Ajouter un nouvel utilisateur.
     *
     * @param user L'utilisateur envoyé en JSON.
     * @return Une réponse HTTP 201 CREATED contenant l'utilisateur ajouté.
     */
    @POST
    public Response ajouterUtilisateur(User user) {
        utilisateurs.add(user);
        return Response.status(Response.Status.CREATED) // 201 Created
                .entity(user)
                .build();
    }

    /**
     * Supprimer un utilisateur par son ID (index dans la liste).
     *
     * @param id L'index de l'utilisateur à supprimer.
     * @return Une réponse HTTP 204 NO CONTENT si suppression réussie, sinon 404 NOT FOUND.
     */
    @DELETE
    @Path("/{id}")
    public Response supprimerUtilisateur(@PathParam("id") int id) {
        if (id < 0 || id >= utilisateurs.size()) {
            return Response.status(Response.Status.NOT_FOUND) // 404 Not Found
                    .entity("Utilisateur avec ID " + id + " introuvable.")
                    .build();
        }
        utilisateurs.remove(id);
        return Response.status(Response.Status.NO_CONTENT).build(); // 204 No Content
    }
}
