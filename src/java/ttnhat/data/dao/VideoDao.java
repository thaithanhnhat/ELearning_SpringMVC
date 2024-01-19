/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ttnhat.data.dao;

import java.util.List;
import ttnhat.data.model.Video;

/**
 *
 * @author nhatt
 */
public interface VideoDao {
    public List<Video> findCourseVideo(int id_course);
    public Video findInfoVideo(int id_video);
     public List<Video> findAll();
      public void updateVideo(Video video);
     public void insertVideo(Video video);
      public void deleteVideo(int id);
}
