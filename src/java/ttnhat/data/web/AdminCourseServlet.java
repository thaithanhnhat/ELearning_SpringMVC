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
import ttnhat.data.model.Category;
import ttnhat.data.model.Course;
import ttnhat.data.model.Video;

/**
 *
 * @author nhatt
 */
public class AdminCourseServlet extends HttpServlet {


 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           doPost(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("title", "Contro course");
        
           
           List<Course> listCourse = Database.getCourseDao().findAll();
           request.setAttribute("listCourse", listCourse);
           List<Video> listVideo = Database.getVideoDao().findAll();
           request.setAttribute("listVideo", listVideo);
           List<Category> listCategory = Database.getCategoryDao().findAll();
           request.setAttribute("listCategory", listCategory);
           request.getRequestDispatcher("./views/controlcourse.jsp").include(request,response);
    }

}
