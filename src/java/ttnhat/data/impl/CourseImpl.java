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
import ttnhat.data.dao.CourseDao;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Category;
import ttnhat.data.model.Course;

/**
 *
 * @author nhatt
 */
public class CourseImpl  implements CourseDao {
    Connection conn = MySQLDriver.getConnection();
    public List<Course> findAll(){
        List<Course> listCourse = new ArrayList<>();
        String sql ="select * from share3s.course";
        try {
       
            PreparedStatement sttm = conn.prepareStatement(sql);
            ResultSet rs = sttm.executeQuery();
            while(rs.next()){
                listCourse.add(new Course(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listCourse;
    }
    
     public void addCourse(Course newCourse) {
        String sql = "INSERT INTO share3s.course (id_category, name, price, img, status, rated) VALUES ( ?, ?, ?, ?, ?, ?)";
        
        try {           
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, newCourse.getId_category());
            statement.setString(2, newCourse.getName());
            statement.setDouble(3, newCourse.getPrice());
            statement.setString(4, newCourse.getImg());
            statement.setInt(5, newCourse.getStatus());
            statement.setInt(6, newCourse.getRated());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL errors here
        }
    }
     public void deleteCourse(int courseId) {
        String sql = "DELETE FROM share3s.course WHERE id = ?";

         try {           
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, courseId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      public void updateCourse(Course course) {
        String sql = "UPDATE course SET id_category = ?, name = ?, price = ?, img = ?, status = ?, rated = ? WHERE id = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, course.getId_category());
            statement.setString(2, course.getName());
            statement.setDouble(3, course.getPrice());
            statement.setString(4, course.getImg());
            statement.setInt(5, course.getStatus());
            statement.setInt(6, course.getRated());
            statement.setInt(7, course.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
