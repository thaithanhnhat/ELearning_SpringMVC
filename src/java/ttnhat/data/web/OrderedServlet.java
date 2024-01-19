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
import ttnhat.data.model.Cart;
import ttnhat.data.model.Ordered;
import ttnhat.data.model.User;

/**
 *
 * @author nhatt
 */
public class OrderedServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

 
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Payment");
        User user = (User) request.getSession().getAttribute("user");
        
        Database.getOrderedDao().removeCart(user.getId());
        response.sendRedirect("course");
        
        
    }

 
}
