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
public class Video {
    private int id;
    private int id_course;
    private String title;
    private String describe;
    private int view_quantily;
    private String url_video;

    public Video(int id, int id_course, String title, String describe, int view_quantily, String url_video) {
        this.id = id;
        this.id_course = id_course;
        this.title = title;
        this.describe = describe;
        this.view_quantily = view_quantily;
        this.url_video = url_video;
    }
    public Video(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.id_course = rs.getInt("id_course");
        this.title = rs.getString("title");
        this.describe = rs.getString("describe");
        this.view_quantily = rs.getInt("view_quantily");
        this.url_video = rs.getString("url_video");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getView_quantily() {
        return view_quantily;
    }

    public void setView_quantily(int view_quantily) {
        this.view_quantily = view_quantily;
    }

    public String getUrl_video() {
        return url_video;
    }

    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }
    
    
}
