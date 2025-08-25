package com.example.servlet;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config.AppConfig;
import com.example.model.Vehicle;
import com.example.services.IVehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="deleteVehicle", value="/vehicle/delete")
public class VehicleDeleteServlet extends HttpServlet {
    private IVehicleService vehicleService;
    private AnnotationConfigApplicationContext ctx;

    @Override
    public void init() throws ServletException {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        this.vehicleService = ctx.getBean(IVehicleService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/deleteVehicle.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String plate = request.getParameter("placa");
        String message;
        if (plate == null || plate.trim().isEmpty()) {
            message = "Por favor ingrese una placa.";
        } else {
            Vehicle vehicle = vehicleService.findByPlate(plate);
            if (vehicle == null) {
                message = "No se encontró un vehículo con placa: " + plate;
            } else {
                vehicleService.deleteByPlate(plate);
                message = "Vehículo con placa " + plate + " eliminado.";
            }
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/views/deleteVehicle.jsp")
               .forward(request, response);
    }

    @Override
    public void destroy() {
        if (ctx != null) {
            ctx.close();
        }
    }
}

