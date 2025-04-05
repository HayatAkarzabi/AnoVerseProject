package Metier;

import Utils.SerializationManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import Utils.SerializationManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Seance seance;

    @OneToOne(cascade = CascadeType.ALL)
    private Paiement paiement;
    private Date dateReservation;

    private int nombrePlaces;

    @ManyToOne(fetch = FetchType.LAZY)
    private Film film;
    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id")
    private Place place;


    @Column(nullable = false)
    private String statut = "CONFIRMÉ"; // ou "ANNULÉ", "EN_ATTENTE"

    public Reservation(Film film, Seance seance, Date dateReservation, int nombrePlaces) {
        this.film = film;
        this.seance = seance;
        this.dateReservation = dateReservation;
        this.nombrePlaces = nombrePlaces;
    }

    public Reservation(User user, Seance seance, Date dateReservation, int nombrePlaces) throws IOException {
        this.user = user;
        this.seance = seance;
        this.dateReservation = dateReservation;
        this.nombrePlaces = nombrePlaces;
        SerializationManager.SérialiserObjet(this, "Serialisation.ser");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Paiement getPaiement() {
        return paiement;
    }

    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Reservation(Film film, Date dateReservation, int nombrePlaces) throws IOException {
        this.film = film;

    }
}