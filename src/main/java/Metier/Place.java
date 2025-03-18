package Metier;

import Utils.SerializationManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id ;
    @ManyToOne
    private Salle salle;
    private int numero;
    private boolean estResrvee;

    public Place(boolean estResrvee, int numero, Salle salle) throws IOException {
        this.estResrvee = estResrvee;
        this.numero = numero;
        this.salle = salle;
        SerializationManager.SérialiserObjet(this,"Serialisation.ser");
    }
}
