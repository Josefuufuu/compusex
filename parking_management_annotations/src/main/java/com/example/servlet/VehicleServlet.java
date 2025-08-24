package com.example.servlet;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config.AppConfig;
import com.example.model.Driver;
import com.example.model.Vehicle;
import com.example.services.IDriverService;
import com.example.services.IVehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vehicles")
public class VehicleServlet extends HttpServlet {

    private IVehicleService vehicleService;
    private IDriverService driverService;

    @Override
    public void init() throws ServletException {
        super.init();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        vehicleService = ctx.getBean(IVehicleService.class);
        driverService = ctx.getBean(IDriverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String plate = req.getParameter("plate");
        if (plate != null && !plate.isBlank()) {
            Vehicle vehicle = vehicleService.findByPlate(plate);
            req.setAttribute("vehicle", vehicle);
            req.setAttribute("title", "Resultado de búsqueda");
        } else {
            req.setAttribute("vehicles", vehicleService.findAll());
            req.setAttribute("title", "Listado de vehículos");
        }
        req.getRequestDispatcher("vehicles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("addVehicle".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            String plate = req.getParameter("plate");
            int cylinder = Integer.parseInt(req.getParameter("cylinder"));
            String fuelType = req.getParameter("fuel_type");
            String motorNumber = req.getParameter("motor_number");
            String brand = req.getParameter("brand");
            String series = req.getParameter("series");
            String driverIdent = req.getParameter("driver_ident");
            Driver driver = driverService.getDriver(driverIdent);
            if (driver != null) {
                Vehicle vehicle = new Vehicle(brand, cylinder, fuelType, id, motorNumber, plate, series);
                vehicleService.addToDriver(driver, vehicle);
            }
        } else if ("delete".equals(action)) {
            String plate = req.getParameter("plate");
            vehicleService.deleteByPlate(plate);
        }
        resp.sendRedirect("vehicles");
    }
}
