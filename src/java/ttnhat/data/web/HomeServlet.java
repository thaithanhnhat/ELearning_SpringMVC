/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ttnhat.data.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import ttnhat.data.dao.Database;
import ttnhat.data.model.Category;
import ttnhat.data.model.Course;
import ttnhat.data.model.User;

/**
 *
 * @author nhatt
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           request.setAttribute("title", "Home page");

         
            Cookie[] cookies = request.getCookies();
            String userData = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userData")) {
                        userData = cookie.getValue();
                        break;
                    }
                }
            }

            // Tạo lại đối tượng User từ chuỗi dữ liệu
    
            if (userData != null) {
                String[] parts = userData.split(":");
                if (parts.length == 7) { // Kiểm tra xem có đủ thông tin để tạo User hay không   
                    User user = new User();
                    user.setId(Integer.parseInt(parts[0]));
                    user.setEmail(parts[1]);
                    user.setPhone(parts[2]);
                    user.setPassword(parts[3]);
                    user.setName(parts[4]);
                    user.setStatus(Integer.parseInt(parts[5]));
                    user.setRole(parts[6]);
                    request.getSession().setAttribute("user", user);
                }
            }
          
                
          
           List<Category> listCategory = Database.getCategoryDao().findAll();
           request.getSession().setAttribute("listCategory", listCategory);
           
           List<Course> listCourse = Database.getCourseDao().findAll();
           request.setAttribute("listCourse", listCourse);
           
           request.setAttribute("id_category", request.getParameter("id_category"));
           
           request.getRequestDispatcher("./views/home.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }


}
