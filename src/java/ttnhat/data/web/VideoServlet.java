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
import java.util.List;
import ttnhat.data.dao.Database;
import ttnhat.data.model.Video;

/**
 *
 * @author nhatt
 */
public class VideoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
          
        
         
                 
            request.getRequestDispatcher("./views/video.jsp").include(request,response);
            
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setAttribute("title", "Video page");      
            if(request.getParameter("id_course")!=null){
                int id_course=Integer.parseInt(request.getParameter("id_course"));
                List<Video> listVideo = Database.getVideoDao().findCourseVideo(id_course);      
                Video video_start = listVideo.get(0);
                 request.setAttribute("listVideo", listVideo);  
                request.setAttribute("video_start", video_start);
            }
            else{
                int id_video = Integer.parseInt(request.getParameter("id_video"));
                Video video_start = Database.getVideoDao().findInfoVideo(id_video);              
                List<Video> listVideo = Database.getVideoDao().findCourseVideo(video_start.getId_course());      
                request.setAttribute("listVideo", listVideo);    
                request.setAttribute("video_start", video_start);
            }
          request.getRequestDispatcher("./views/video.jsp").include(request,response);
    }

   

    
}
