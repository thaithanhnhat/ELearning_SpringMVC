/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.impl;

import com.mysql.cj.PreparedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ttnhat.data.dao.VideoDao;
import ttnhat.data.driver.MySQLDriver;
import ttnhat.data.model.Course;
import ttnhat.data.model.User;
import ttnhat.data.model.Video;

/**
 *
 * @author nhatt
 */
public class VideoImpl implements VideoDao {
     Connection conn = MySQLDriver.getConnection();
    public List<Video> findCourseVideo(int id_course){
        String sql = "select * from share3s.video where id_course="+id_course;
          List<Video> listVideo = new ArrayList<>();        
         try {
              PreparedStatement sttm = conn.prepareStatement(sql);
             ResultSet rs = sttm.executeQuery();
             while(rs.next()){
                    listVideo.add(new Video(rs));
               }
         } catch (SQLException ex) {
             Logger.getLogger(VideoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
       return listVideo;
    }
     public List<Video> findAll(){
        String sql = "select * from share3s.video";
          List<Video> listVideo = new ArrayList<>();        
         try {
              PreparedStatement sttm = conn.prepareStatement(sql);
             ResultSet rs = sttm.executeQuery();
             while(rs.next()){
                    listVideo.add(new Video(rs));
               }
         } catch (SQLException ex) {
             Logger.getLogger(VideoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
       return listVideo;
    }
      public Video findInfoVideo(int id_video){
          String sql ="select * from share3s.video where id="+id_video;
       
         try {
               PreparedStatement sttm = conn.prepareStatement(sql);
               ResultSet rs = sttm.executeQuery();
                if(rs.next()) return new Video(rs);
         } catch (SQLException ex) {
             Logger.getLogger(VideoImpl.class.getName()).log(Level.SEVERE, null, ex);
         }
          
      
        return null;
      }
       public void updateVideo(Video video) {
           String idCourse = String.valueOf(video.getId_course());
            String title = "N'" + video.getTitle() + "'";
            String describe = "N'" + video.getDescribe() + "'";
            String urlVideo = "N'" + video.getUrl_video() + "'";
            String id = String.valueOf(video.getId());

            String sql = "UPDATE share3s.video SET id_course=" + idCourse + ", title=" + title + ", `describe`=" + describe + ", url_video=" + urlVideo + " WHERE id=" + id; 
        try {         
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    public void insertVideo(Video video) {
        PreparedStatement statement = null;

        try {
        
            String sql = "INSERT INTO share3s.video (id_course, title, `describe`, view_quantily, url_video) VALUES (?, ?, ?, ?, ?)";

            // Tạo PreparedStatement
            statement = conn.prepareStatement(sql);

            // Gán các giá trị của video mới cho các tham số trong câu lệnh SQL
            statement.setInt(1, video.getId_course());
            statement.setString(2, video.getTitle());
            statement.setString(3, video.getDescribe());
            statement.setInt(4, video.getView_quantily());
            statement.setString(5, video.getUrl_video());

            // Thực thi câu lệnh chèn
            statement.executeUpdate();

            // Đã chèn thông tin video mới thành công
        } catch (SQLException e) {
            // Xử lý lỗi khi chèn không thành công
            e.printStackTrace();
        } 
    }
    public void deleteVideo(int id) {
      
        String sql = "DELETE FROM share3s.video where id="+id;
        try {         
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
