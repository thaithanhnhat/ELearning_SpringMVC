/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.model;

/**
 *
 * @author nhatt
 */
public class Payment {
  private int id;
  private String name_method;
  private String img;

    public Payment(int id, String name_method, String img) {
        this.id = id;
        this.name_method = name_method;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_method() {
        return name_method;
    }

    public void setName_method(String name_method) {
        this.name_method = name_method;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
  
}
