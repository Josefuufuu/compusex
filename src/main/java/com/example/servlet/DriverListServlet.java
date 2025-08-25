package com.example.servlet;

import java.io.IOException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.services.IDriverService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="drivers", value="/drivers")
public class DriverListServlet extends HttpServlet {
    private IDriverService driverService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        this.driverService = ctx.getBean(IDriverService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        request.setAttribute("drivers", driverService.findAll());
        request.getRequestDispatcher("/WEB-INF/views/drivers.jsp")
                .forward(request, response);
    }
}
