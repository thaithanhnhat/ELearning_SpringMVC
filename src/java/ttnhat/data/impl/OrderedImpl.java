/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.impl;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ttnhat.data.dao.OrderedDao;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Ordered;

/**
 *
 * @author nhatt
 */
public class OrderedImpl implements OrderedDao {
    Connection conn = MySQLDriver.getConnection();
    public  void removeCart(int user){
        
        String sql = "INSERT INTO share3s.ordered(id_user,id_course)SELECT * FROM share3s.cart";
   
        try {
            PreparedStatement sttm = conn.prepareStatement(sql);
            sttm.executeUpdate();
            String sql1 = "DELETE from cart where id_user="+user;
            sttm.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(OrderedImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<Ordered> findAll(int id_user){
        List<Ordered> listOrdered = new ArrayList<>();
        String sql ="select * from share3s.ordered where id_user="+id_user;
        try { 
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){   
                listOrdered.add(new Ordered(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOrdered;
    
    }
    
}
