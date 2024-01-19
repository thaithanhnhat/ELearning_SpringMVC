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
import ttnhat.data.model.Course;
import ttnhat.data.model.Ordered;
import ttnhat.data.model.User;

/**
 *
 * @author nhatt
 */
public class CourseServlet extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException {
        
        request.setAttribute("title", "Home page");
        User user =(User) request.getSession().getAttribute("user");
        if(user!=null){
        
            List<Ordered> listOrdered = Database.getOrderedDao().findAll(user.getId());
            request.setAttribute("listOrdered", listOrdered);

            List<Course> listCourse = Database.getCourseDao().findAll();
            request.setAttribute("listCourse", listCourse);
            request.getRequestDispatcher("./views/course.jsp").include(request,response);
        }
        else{
               request.getRequestDispatcher("./views/login.jsp").include(request,response);
        }
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

 
 
}
