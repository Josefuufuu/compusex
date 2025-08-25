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

@WebServlet(name="addVehicle", value="/vehicle/add")
public class VehicleAddServlet extends HttpServlet {
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
        request.getRequestDispatcher("/WEB-INF/views/addVehicle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String plate = request.getParameter("plate");
        String brand = request.getParameter("brand");
        String cylinderStr = request.getParameter("cylinder");
        String fuelType = request.getParameter("fuel_type");
        String motorNumber = request.getParameter("motor_number");
        String series = request.getParameter("series");
        String message;

        if (plate == null || plate.trim().isEmpty()) {
            message = "La placa es obligatoria.";
        } else {
            int cylinder = 0;
            try {
                cylinder = Integer.parseInt(cylinderStr);
            } catch (NumberFormatException e) {
                cylinder = 0;
            }
            int id = vehicleService.findAll().size() + 1;
            Vehicle vehicle = new Vehicle(brand, cylinder, fuelType, id, motorNumber, plate, series);
            vehicleService.addVehicle(vehicle);
            message = "Vehículo agregado correctamente.";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/views/addVehicle.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        if (ctx != null) {
            ctx.close();
        }
    }
}
