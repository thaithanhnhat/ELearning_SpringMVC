/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ttnhat.data.dao.UserDao;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Course;
import ttnhat.data.model.User;

/**
 *
 * @author nhatt
 */
public class UserImpl implements UserDao {
    Connection conn = MySQLDriver.getConnection();
    public User getUser(String emailphone,String password){
        String sql;
        if(emailphone.contains("@")){
            sql = "select * from user where email='"+emailphone+"' and password='"+password+"'";
        }
        else{
            sql = "select * from user where phone='"+emailphone+"' and password='"+password+"'";
        }
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if(rs.next()) return new User(rs);
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public void insertUser(User user){
        String sql = "insert into share3s.user(email,phone,password,name,status,role) values("
                        +"'"+user.getEmail()+"',"
                        +"'"+user.getPhone()+"',"
                        +"'"+user.getPassword()+"',"
                        +"'"+user.getName()+"',"
                        +user.getStatus()+","
                        +user.getRole()+")";
        
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }   
    public boolean checkUser(String email,String phone){
        String sql = "select * from user where email='"+email+"' and phone='"+phone+"'";       
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if(rs.next()) return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
     public List<User> findAll(){       
            List<User> listUser = new ArrayList<>();
            String sql ="select * from share3s.User";
            try { 
                PreparedStatement sttm = conn.prepareStatement(sql);
                ResultSet rs = sttm.executeQuery();
                while(rs.next()){   
                    listUser.add(new User(rs));
                }

            } catch (SQLException ex) {
                Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listUser;
    
          
         
     }
     public void deleteUser(int userId) {
    String sql = "DELETE FROM share3s.user WHERE id = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, userId);  // Bind the user ID parameter
        stmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, "Error deleting user", ex);
        throw new RuntimeException("Failed to delete user", ex);  // Rethrow as a RuntimeException for proper handling
    }
}
public void updateUser(User user) {
    String sql = "UPDATE share3s.user SET email = ?, phone = ?, password = ?, name = ?, status = ?, role = ? WHERE id = ?";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getEmail());
        stmt.setString(2, user.getPhone());
        stmt.setString(3, user.getPassword());
        stmt.setString(4, user.getName());
        stmt.setInt(5, user.getStatus());
        stmt.setString(6, user.getRole());
        stmt.setInt(7, user.getId());  // Assuming User has an 'id' field
        stmt.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, "Error updating user", ex);
        throw new RuntimeException("Failed to update user", ex);  // Rethrow for proper handling
    }
}

}
