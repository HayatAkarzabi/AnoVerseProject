package Metier;

import Utils.SerializationManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString



public class Paiement  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private LocalDate date;
    private PaimementType méthode;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


    public Paiement(LocalDate date, Double montant, PaimementType méthode, Reservation reservation) throws IOException {
        this.date = date;
        this.montant = montant;
        this.méthode = méthode;
        this.reservation = reservation;
//        SerializationManager.SérialiserObjet(this,"Serialisation.ser");
    }
}
