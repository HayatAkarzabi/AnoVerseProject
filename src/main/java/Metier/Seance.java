package Metier;

import Utils.SerializationManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Seance /*implements Serializable*/ {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime date ;
    private String formattedDate;



    @OneToMany
    List<Reservation> reservations;
    @ManyToOne
    private Salle salle;
    @ManyToOne
    private Film film;

    public Seance(LocalDateTime date,Film film,Salle salle) throws IOException {
        this.date = date;

        this.reservations = new ArrayList<>();
        this.film = film;
        this.salle = salle;
//        SerializationManager.SérialiserObjet(this,"Serialisation.ser");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Film getFilm() {
        return film;
    }

    public String getFormattedDate() {
        return formattedDate;
    }

    public void setFilm(Film film) {
        this.film = film;
    }}


