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
import ttnhat.data.model.Category;
import ttnhat.data.model.Course;
import ttnhat.data.model.User;
import ttnhat.utils.API;
/**
 *
 * @author nhatt
 */
public class CartServlet extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {              
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("title", "Cart page");

         
         User user = (User) request.getSession().getAttribute("user");
         
         if(request.getParameter("delete")!=null){
             Database.getCartDao().deleteCart(user.getId(), Integer.parseInt(request.getParameter("delete")));
         }
         if(user!=null){
            List<Cart> listCart =  Database.getCartDao().findAll(user.getId());
            request.setAttribute("listCart", listCart);
            List<Course> listCourse = Database.getCourseDao().findAll();
            request.setAttribute("listCourse", listCourse);
            List<Category> listCategory = Database.getCategoryDao().findAll();
            request.setAttribute("listCategory", listCourse);
            double sumCart = API.sumCart(listCart, listCourse);
            request.setAttribute("sumCart",sumCart);
            request.getRequestDispatcher("./views/cart.jsp").include(request,response);
         }
         else{
              request.getRequestDispatcher("./views/login.jsp").include(request,response);
         }
    }

 
}
