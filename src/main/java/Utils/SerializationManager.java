package Utils;

import java.io.*;

public class SerializationManager {

    // Sérialiser un objet et le sauvegarder dans un fichier
    public static void SérialiserObjet (Object obj, String fichier) throws IOException {
        FileOutputStream fos = new FileOutputStream(fichier, true); // 'true' pour ajouter au fichier existant
        ObjectOutputStream oos = null;

        // Si le fichier est vide, crée un ObjectOutputStream pour écrire l'en-tête
        if (new File(fichier).length() == 0) {
            oos = new ObjectOutputStream(fos); // Créer un ObjectOutputStream pour le premier objet
        } else {
            oos = new ObjectOutputStream(fos) {
                // Surcharge de la méthode pour ne pas réécrire l'en-tête
                protected void writeStreamHeader() throws IOException {
                    // Ne rien faire
                }
            };
        }

        oos.writeObject(obj); // Sérialiser l'objet
        System.out.println("Objet sauvegardé dans " + fichier);

        oos.close(); // Fermer le flux
    }


    // Charger un objet sérialisé depuis un fichier
    public static Object DésérialiserObjet(String fichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

