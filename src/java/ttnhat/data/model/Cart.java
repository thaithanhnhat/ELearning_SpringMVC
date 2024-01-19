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
public class Cart {
    private int id_user;
    private int id_course;

    public Cart(int id_user, int id_course) {
        this.id_user = id_user;
        this.id_course = id_course;
    }
    public Cart(ResultSet rs) throws SQLException {
        this.id_user = rs.getInt("id_user");
        this.id_course = rs.getInt("id_course");        
    }
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }
    
    
}
