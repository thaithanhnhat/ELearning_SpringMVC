/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ttnhat.data.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import ttnhat.data.dao.Database;
import ttnhat.data.model.Course;

/**
 *
 * @author nhatt
 */
@MultipartConfig
public class SaveCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String name = request.getParameter("name");
            int id_category = Integer.parseInt(request.getParameter("id_category"));
            double price = Double.parseDouble(request.getParameter("price"));       
            String img =saveUploadedFile(request, response);   
            Course course = new Course(0, id_category, name, price, img, 1, 5);
            Database.getCourseDao().addCourse(course);
            response.sendRedirect("AdminCourse");
    }
    
    
    
    
    private String saveUploadedFile(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String uploadPath = getServletContext().getRealPath("") + File.separator + "assets" + File.separator + "img";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        Part filePart = request.getPart("img");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Lấy tên file gốc

        OutputStream out = null;
        InputStream filecontent = null;

        try {
            out = new FileOutputStream(new File(uploadPath + File.separator + fileName));
            filecontent = filePart.getInputStream();

            int read;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            return fileName; 
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
            return null; 
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
        }
    }

}
