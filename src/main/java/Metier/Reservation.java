package Metier;

import Utils.SerializationManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor

public class Reservation  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Seance seance;
    @OneToOne
    private Paiement paiement;
    private Date dateReservation;
    private int nmbr_places;
    public Reservation(){}

    public Reservation(User user,Seance seance,   Date dateReservation, int nmbr_places) throws IOException {
        this.user = user;
        this.dateReservation = dateReservation;
        this.nmbr_places = nmbr_places;
        this.seance = seance;
        SerializationManager.SérialiserObjet(this,"Serialisation.ser");
    }
}