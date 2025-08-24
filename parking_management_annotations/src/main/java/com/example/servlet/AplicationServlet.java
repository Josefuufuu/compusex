package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="MainApp", value="Si") 
public class AplicationServlet extends HttpServlet{
    
    private String message;
    @Override
    public void init(){
         message = "Server is running";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
         out.println("<html><body>");
         out.println("<h1>" + message + "</h1>");
         out.println("</body></html>");
        

    }
    @Override
    public void destroy(){
        message = "This servet is not running";
    }
    
}
