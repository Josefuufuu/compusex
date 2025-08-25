package com.example.servlet;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config.AppConfig;
import com.example.model.Driver;
import com.example.model.Vehicle;
import com.example.services.IDriverService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="driverVehicles", value="/driver/vehicles")
public class DriverVehiclesServlet extends HttpServlet {
    private IDriverService driverService;
    private AnnotationConfigApplicationContext ctx;

    @Override
    public void init() throws ServletException {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        this.driverService = ctx.getBean(IDriverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/driverVehicles.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identNumber = request.getParameter("ident_number");
        List<Vehicle> vehicles = null;
        String message = null;

        if (identNumber == null || identNumber.trim().isEmpty()) {
            message = "Por favor ingrese una cédula.";
        } else {
            Driver driver = driverService.getDriver(identNumber);
            if (driver == null) {
                message = "Conductor no encontrado.";
            } else {
                vehicles = driver.getVehicles();
                if (vehicles.isEmpty()) {
                    message = "El conductor no tiene vehículos registrados.";
                }
            }
        }

        request.setAttribute("vehicles", vehicles);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/views/driverVehicles.jsp")
               .forward(request, response);
    }

    @Override
    public void destroy() {
        if (ctx != null) {
            ctx.close();
        }
    }
}
