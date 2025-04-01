package Dao;

import Metier.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ImplUser implements IUser {
    private EntityManager em ;
    public ImplUser() {
        em= Persistence.createEntityManagerFactory("demo").createEntityManager();
    }


    public void AddUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();


    }

    @Override
    public void UpdateUser(int id) {
        em.getTransaction().begin();
        em.merge(em.find(User.class, id));
        em.getTransaction().commit();


    }

    @Override
    public void DeleteUser(int id) {
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();


    }

    @Override

    public User findUser(String email) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Affiche l'erreur en cas de problème
            return null; // Retourne null si l'utilisateur n'est pas trouvé
        }
    }




}
