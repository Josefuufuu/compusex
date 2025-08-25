package com.example.servlet;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config.AppConfig;
import com.example.services.IVehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 @WebServlet(name="vehiculos", value="/vehicle")
public class VehicleListServlet extends HttpServlet {
    private IVehicleService vehicleService;
    private AnnotationConfigApplicationContext ctx;

    @Override
    public void init() throws ServletException {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
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

    @Override
    public void destroy() {
        if (ctx != null) {
            ctx.close();
        }
    }
}
