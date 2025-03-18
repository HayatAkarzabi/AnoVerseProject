package Metier;
import Utils.SerializationManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private int capacite;


    public Salle(String numero, int capacite) throws IOException {
        this.numero = numero;
        this.capacite = capacite;
        SerializationManager.SérialiserObjet(this,"Serialisation.ser");
    }
}