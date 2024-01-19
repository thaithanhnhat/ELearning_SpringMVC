/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ttnhat.data.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ttnhat.data.dao.Database;
import ttnhat.data.model.User;

/**
 *
 * @author nhatt
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("title", "Login page");
         request.getRequestDispatcher("./views/login.jsp").include(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailphone = request.getParameter("username");
        String password = request.getParameter("password");
        User user = Database.getUserDao().getUser(emailphone, password);
        // Lấy thông tin từ đối tượng User và tạo chuỗi dữ liệu để lưu vào cookie
        String userData = user.getId() + ":" + user.getEmail() + ":" + user.getPhone() + ":" + user.getPassword() + ":" + user.getName() + ":" + user.getStatus() + ":" + user.getRole();

        // Lưu chuỗi dữ liệu vào cookie
        Cookie userCookie = new Cookie("userData", userData);
        response.addCookie(userCookie); // Gửi cookie về client

        if(user==null){
            request.getSession().setAttribute("error_login", "Your infomation user incorrect!");
            request.getSession().setAttribute("check", "Your infomation user incorrect!");
            response.sendRedirect("login");
        }else{
            if(user.getRole()=="admin"){
                request.getSession().setAttribute("login_succes", "Login succes");
                response.sendRedirect("admin");
            }
            else{
                request.getSession().setAttribute("user",user);       
                request.getSession().removeAttribute("error_login");
                request.getSession().removeAttribute("check");
                response.sendRedirect("home");
            }
        }
  
    }


}
