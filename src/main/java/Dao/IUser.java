package Dao;

import Metier.User;

public interface IUser {
    void AddUser(User user);
    void UpdateUser(int id);
    void DeleteUser(int id);

}
