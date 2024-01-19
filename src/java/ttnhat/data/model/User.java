/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nhatt
 */
public class User {
    private int id;
    private String email;
    private String phone;
    private String password;
    private String name;  
    private int status;
    private String role;

    public User(int id, String email, String phone, String password, String name, int status, String role) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.status = status;
        this.role = role;
    }
     public User() {
      
    }
    
     public User(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.email = rs.getString("email");
        this.phone = rs.getString("phone");
        this.password = rs.getString("password");
        this.name = rs.getString("name");
        this.status = rs.getInt("status");
        this.role = rs.getString("role");   
    }
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
   
    
    
}
