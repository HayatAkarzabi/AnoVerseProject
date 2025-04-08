package Dao;

import Metier.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplUser implements IUser {
    private EntityManager em ;
    public ImplUser() {
        em= Persistence.createEntityManagerFactory("aniverse").createEntityManager();
    }


    public void AddUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();


    }

    @Override
    public void UpdateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();


    }

    @Override
    public void DeleteUser(Long id) {
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
    public User findUserById(Long id) {
        try {
            em.getTransaction().begin();
            return em.find(User.class, id);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }



}
