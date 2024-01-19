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
public class Course {
    private int id;
    private int id_category;
    private String name; 
    private double price;
    private String img;
    private int status;
    private int rated;

    public Course(int id, int id_category, String name, double price, String img, int status, int rated) {
        this.id = id;
        this.id_category = id_category;
        this.name = name;
        this.price = price;
        this.img = img;
        this.status = status;
        this.rated = rated;
    }
      public Course(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.id_category = rs.getInt("id_category");
        this.name = rs.getString("name");
        this.price = rs.getDouble("price");
        this.img = rs.getString("img");
        this.status = rs.getInt("status");
        this.rated = rs.getInt("rated");           
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRated() {
        return rated;
    }

    public void setRated(int rated) {
        this.rated = rated;
    }
    
    
}
