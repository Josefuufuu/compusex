package com.example.servlet;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config.AppConfig;
import com.example.services.IDriverService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="drivers", value="/drivers")
public class DriverListServlet extends HttpServlet {
    private IDriverService driverService;
    private AnnotationConfigApplicationContext ctx;

    @Override
    public void init() throws ServletException {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
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

    @Override
    public void destroy() {
        if (ctx != null) {
            ctx.close();
        }
    }
}
