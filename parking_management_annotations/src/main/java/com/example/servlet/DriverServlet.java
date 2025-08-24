package com.example.servlet;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config.AppConfig;
import com.example.model.Driver;
import com.example.services.IDriverService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/drivers")
public class DriverServlet extends HttpServlet {

    private IDriverService driverService;

    @Override
    public void init() throws ServletException {
        super.init();
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        driverService = ctx.getBean(IDriverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String identNumber = req.getParameter("ident_number");
        if (identNumber != null && !identNumber.isBlank()) {
            Driver driver = driverService.getDriver(identNumber);
            req.setAttribute("driver", driver);
            req.setAttribute("title", "Vehículos del conductor");
        } else {
            req.setAttribute("drivers", driverService.findAll());
            req.setAttribute("title", "Listado de conductores");
        }
        req.getRequestDispatcher("drivers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("addDriver".equals(action)) {
            int id = driverService.findAll().size() + 1;
            String name = req.getParameter("name");
            String position = req.getParameter("position");
            String idType = req.getParameter("id_type");
            String identNumber = req.getParameter("ident_number");
            Driver driver = new Driver(id, name, position, idType, identNumber);
            driverService.addDriver(driver);
        }
        resp.sendRedirect("drivers");
    }
}
