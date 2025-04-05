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
import java.util.List;

@Entity

@NoArgsConstructor
@Data
@ToString

public class Seance /*implements Serializable*/ {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDateTime date ;
    @OneToMany
    List<Reservation> reservations;
    @ManyToOne
    private Salle salle;
    @ManyToOne
    private Film film;

    public Seance(LocalDateTime date, Long id,Film film,Salle salle) throws IOException {
        this.date = date;
        this.id = id;
        this.reservations = new ArrayList<>();
        this.film = film;
        this.salle = salle;
//        SerializationManager.SérialiserObjet(this,"Serialisation.ser");
    }
}
