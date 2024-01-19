/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ttnhat.data.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ttnhat.data.dao.Database;
import ttnhat.data.model.Video;

/**
 *
 * @author nhatt
 */
public class SaveAndDeleteVideoServlet extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id_video = Integer.parseInt(request.getParameter("id_video"));
            int id_course = Integer.parseInt(request.getParameter("id_course"));
            String title = request.getParameter("title");
            String describe = request.getParameter("describe");
            String url_video = request.getParameter("url_video");
            if(id_video!=0){
                 Video video = new Video(id_video, id_course, title, describe, 0, url_video);
                 Database.getVideoDao().updateVideo(video);
            }
            else{
                 Video video = new Video(id_video, id_course, title, describe, 0, url_video);
                 Database.getVideoDao().insertVideo(video);
            }
        
            response.sendRedirect("AdminCourse");
               
            
    }


}
