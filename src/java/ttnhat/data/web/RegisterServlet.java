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
import ttnhat.data.model.User;

/**
 *
 * @author nhatt
 */
public class RegisterServlet extends HttpServlet {

   
    


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("title", "Register Page");
        request.getRequestDispatcher("./views/register.jsp").include(request,response);     
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String password=request.getParameter("password");
        String repassword=request.getParameter("repassword");
        boolean check = false;
        if(name.length()==0){
            request.setAttribute("error_name", "   Data not valid!");   
            check = false;
        }
        if(phone.length()<10){
           request.setAttribute("error_phone", "   Data not valid!");  
           check = false;
        }

        if(!email.contains("@")){
            check = false;
            request.setAttribute("error_email", "   Data not valid!");      
        }
        else{
            check = true;
        }
        if(password.equals(repassword)){
            if(password.length()>0){
                password = request.getParameter("password");  
                check = true;
            }
            else{
                request.setAttribute("error_password", "Minimum of 8 characters !");
                check = false;
            }
        }
        else{
            request.setAttribute("error_repassword", "   Data not valid!");
            check = false;
        }   
        
        if(check){
            
            if(Database.getUserDao().checkUser(email, phone)){
                request.setAttribute("error_user", "Infomation already exist!");             
            }
            else{
                User user = new User(1,email,phone,password,name,1,null);              
                Database.getUserDao().insertUser(user);
                request.getRequestDispatcher("./views/login.jsp").include(request,response); 
            }
        }
        request.getRequestDispatcher("./views/register.jsp").include(request,response); 
    }

}
