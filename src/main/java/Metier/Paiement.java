package Metier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paiement implements Serializable {
    private double price;
    private Film film;
    private PaimementType type;

}
