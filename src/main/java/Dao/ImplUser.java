package Dao;

import Metier.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ImplUser implements IUser {
    private EntityManagerFactory emf;
    private EntityManager em;

    public ImplUser() {
        emf = Persistence.createEntityManagerFactory("demo");
        em = emf.createEntityManager();
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
            e.printStackTrace();
            return null;
        }
    }

    // Important: Add a method to properly close resources
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}