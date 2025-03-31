package Metier;

import Utils.SerializationManager;
import jakarta.persistence.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String motDePasse;

    private String role;

    @OneToMany
    private List<Notification> notifications;

    @OneToMany
    private List<Reservation> reservations;

    // Constructeur par défaut : rôle = "client"
    public User() {
        this.role = "client";
        this.reservations = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public User(String nom, String email, String motDePasse, String role) throws IOException {
        this.nom = nom;
        this.email = email;
        this.motDePasse = BCrypt.hashpw(motDePasse, BCrypt.gensalt());
        this.role = (role == null || role.isEmpty()) ? "client" : role;
        this.reservations = new ArrayList<>();
        this.notifications = new ArrayList<>();
        SerializationManager.SérialiserObjet(this, "Serialisation.ser");
    }
    public User( String email, String motDePasse){
        this.email=email;
        this.motDePasse=BCrypt.hashpw(motDePasse, BCrypt.gensalt());
    }

    public String getEmail() {
        return email;
    }

    public User(String emil, String MotDePasse, String role){
        this.email=emil;
        this.motDePasse=MotDePasse;
        this.role=role;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    // Getters et Setters
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = (role == null || role.isEmpty()) ? "client" : role;
    }
    // Dans la classe User (si c'est là que vous voulez gérer le hachage)
    public void setMotDePasse(String motDePasse) {
        // Hacher le mot de passe avant de le stocker
        this.motDePasse = BCrypt.hashpw(motDePasse, BCrypt.gensalt());
    }
}
