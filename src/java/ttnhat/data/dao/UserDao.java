/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ttnhat.data.dao;

import java.util.List;
import ttnhat.data.model.User;

/**
 *
 * @author nhatt
 */
public interface UserDao {
    public User getUser(String emailphone,String password);
    public List<User> findAll();
    public void insertUser(User user);
     public boolean checkUser(String email,String phone);
     public void updateUser(User user);
     public void deleteUser(int userId);
     
}
