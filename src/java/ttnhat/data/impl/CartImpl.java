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
import ttnhat.data.dao.CartDao;
import ttnhat.data.dao.Database;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Cart;
import ttnhat.data.model.Course;

/**
 *
 * @author nhatt
 */
public class CartImpl implements CartDao {
    Connection conn = MySQLDriver.getConnection();
    public List<Cart> findAll(int id_user){
        List<Cart> listCart = new ArrayList<>();
        String sql ="select * from share3s.cart where id_user="+id_user;
        try { 
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){   
                listCart.add(new Cart(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCart;
    
    }
    @Override
    public boolean checkCart(int id_user,int id_course){
        String sql ="select * from share3s.cart where id_user ="+id_user+"and id_course="+id_course;
        try { 
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            if(!rs.next()){   
                return false;
            }
            else{
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    
    }
    @Override
    public void insertCart(int id_user,int id_course){
         String sql1 ="insert into share3s.cart(id_user,id_course) values ("+id_user+","+id_course+")";       
        if(checkCart(id_user, id_course)){
             PreparedStatement sttm1;
             try {
                 sttm1 = conn.prepareStatement(sql1);
                 sttm1.executeUpdate();
             } catch (SQLException ex) {
                 Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }   
    }
    @Override
    public void deleteCart(int id_user,int id_course){
        String sql = "delete from share3s.cart where id_user =" +id_user +" and id_course ="+id_course;
         try {
            PreparedStatement sttm = conn.prepareStatement(sql);        
            sttm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
