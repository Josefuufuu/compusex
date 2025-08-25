package com.example.servlet;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.Driver;
import com.example.services.IDriverService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="addDriver", value="/driver/add")
public class DriverAddServlet extends HttpServlet {
    private IDriverService driverService;
    private ClassPathXmlApplicationContext ctx;

    @Override
    public void init() throws ServletException {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.driverService = ctx.getBean(IDriverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/addDriver.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String position = request.getParameter("position");
        String idType = request.getParameter("id_type");
        String idNumber = request.getParameter("id_number");
        String message;

        if (name == null || name.trim().isEmpty() ||
            idNumber == null || idNumber.trim().isEmpty()) {
            message = "Nombre y número de identificación son obligatorios.";
        } else {
            int id = driverService.findAll().size() + 1;
            Driver driver = new Driver(id, name, position, idType, idNumber);
            driverService.addDriver(driver);
            message = "Conductor agregado correctamente.";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/views/addDriver.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        if (ctx != null) {
            ctx.close();
        }
    }
}
