package Metier;

import Utils.SerializationManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

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
//        SerializationManager.SérialiserObjet(this, "Serialisation.ser");
    }
    public User( String email, String motDePasse){
        this.email=email;
        this.motDePasse = BCrypt.hashpw(motDePasse, BCrypt.gensalt());
    }
    public User( Long id ,String email, String motDePasse,String role){
        this.email=email;
        this.motDePasse = BCrypt.hashpw(motDePasse, BCrypt.gensalt());
        this.role=role;
    }

    public String getEmail() {
        return email;
    }

    public User(String emil, String MotDePasse, String role){
        this.email=emil;
        this.motDePasse = BCrypt.hashpw(MotDePasse, BCrypt.gensalt());
        this.role=role;
    }
    public Long getId() {return id;}

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
}
