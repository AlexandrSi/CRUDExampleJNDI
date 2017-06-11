package dao;

import model.Users;

public interface UserDAO {

    public void addUser(Users user);
    public void updateUser(Users user);
    public void deleteUser(int userID);

}
