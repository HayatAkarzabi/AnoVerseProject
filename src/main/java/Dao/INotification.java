package Dao;

import Metier.Notification;

import java.util.List;

public interface INotification {
    void ajouterNotification(Notification notification);
    void supprimerNotification(Long id);
    List<Notification> afficherListNotification();
    /*void modifierNotification(Long id);*/

}
