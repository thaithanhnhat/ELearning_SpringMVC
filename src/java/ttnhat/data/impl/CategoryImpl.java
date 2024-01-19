/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.impl;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ttnhat.data.dao.CategoryDao;
import ttnhat.data.model.Category;
import ttnhat.data.driver.MySQLDriver;
/**
 *
 * @author nhatt
 */
public class CategoryImpl implements CategoryDao{
    Connection conn = MySQLDriver.getConnection();
    public List<Category> findAll(){
        List<Category> listCategory = new ArrayList<>();
        String sql ="select * from share3s.category";
        try {
       
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                listCategory.add(new Category(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCategory;
    }
}
