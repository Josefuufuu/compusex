package com.example.servlet;

import java.io.IOException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.services.IVehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 @WebServlet(name="vehiculos", value="/vehicle")
public class VehicleListServlet extends HttpServlet {
    private IVehicleService vehicleService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.vehicleService = ctx.getBean(IVehicleService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        response.setContentType("text/html");  
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("vehicles", vehicleService.findAll());
        request.getRequestDispatcher("/WEB-INF/views/vehicles.jsp")
               .forward(request, response); 
    }
}
