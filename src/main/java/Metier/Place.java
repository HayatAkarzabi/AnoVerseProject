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
    @JoinColumn(name = "salle_id", nullable = false)
    private Salle salle;
    private int numero;
    private boolean estResrvee;

    public Place(boolean estResrvee, int numero, Salle salle) throws IOException {
        this.estResrvee = estResrvee;
        this.numero = numero;
        this.salle = salle;
//        SerializationManager.SérialiserObjet(this,"Serialisation.ser");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstResrvee() {
        return estResrvee;
    }

    public void setEstResrvee(boolean estResrvee) {
        this.estResrvee = estResrvee;
    }
}
