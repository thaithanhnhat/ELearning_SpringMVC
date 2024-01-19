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
import ttnhat.data.model.User;

/**
 *
 * @author nhatt
 */
public class AdminUserServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("title", "Control User");
         if(request.getParameter("id_delete")!=null){
             Database.getUserDao().deleteUser(Integer.parseInt(request.getParameter("id_delete")));
         }
         
         List<User> listUser= Database.getUserDao().findAll();
         request.setAttribute("listUser", listUser);
         
         request.getRequestDispatcher("./views/controluser.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("title", "Control User");     
         
         
         String email = request.getParameter("email");
         String phone = request.getParameter("phone");
         String password = request.getParameter("password");
         String name = request.getParameter("name");
         int status = Integer.parseInt(request.getParameter("status"));
         String role = request.getParameter("role");
         int id = Integer.parseInt(request.getParameter("id_update"));
         
         User user = new User(id, email, phone, password, name, status, role);
         Database.getUserDao().updateUser(user);
         List<User> listUser= Database.getUserDao().findAll();
         request.setAttribute("listUser", listUser);
         request.getRequestDispatcher("./views/controluser.jsp").include(request,response);
    }


}
