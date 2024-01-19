/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ttnhat.data.dao;

import java.util.List;
import ttnhat.data.model.Cart;
import ttnhat.data.model.Course;

/**
 *
 * @author nhatt
 */
public interface CartDao {
    public List<Cart> findAll(int id_user);
    public boolean checkCart(int id_user,int id_course);
    public void insertCart(int id_user,int id_course);
    public void deleteCart(int id_user,int id_course);
}
