package Dao;

import Metier.User;

import java.util.List;

public interface IUser {
    void AddUser(User user);
    void UpdateUser(User user);
    void DeleteUser(Long id);
    User findUserById(Long id);
    User findUser(String Email);
    List<User> getAllUsers();

}
