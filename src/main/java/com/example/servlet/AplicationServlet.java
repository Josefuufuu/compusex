package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Vehicle;
import com.example.services.IVehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="MainApp", value="/search-plate")
public class AplicationServlet extends HttpServlet{

    private String message;
    private IVehicleService vehicleService;

    @Override
    public void init(){
         message = "Búsqueda por placa";
         WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
         this.vehicleService = ctx.getBean(IVehicleService.class);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
         out.println("<html><body>");
         out.println("<h1>" + message + "</h1>");
         out.println("<form method='post' action='" + request.getContextPath() + "/vehiculos'>");
         out.println("Placa: <input type='text' name='placa'/>");
         out.println("<input type='submit' value='Buscar'/>");
         out.println("</form>");
         out.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String placa = request.getParameter("placa");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Resultado de búsqueda</h1>");
        if (placa == null || placa.trim().isEmpty()){
            out.println("<p>Por favor ingrese una placa.</p>");
        } else {
            Vehicle vehicle = vehicleService.findByPlate(placa);
            if (vehicle == null) {
                out.println("<p>No se encontró un vehículo con placa: <strong>" + escapeHtml(placa) + "</strong></p>");
            } else {
                out.println("<ul>");
                out.println("<li>Placa: " + escapeHtml(vehicle.getPlate()) + "</li>");
                out.println("<li>Marca: " + escapeHtml(vehicle.getBrand()) + "</li>");
                out.println("<li>Modelo: " + escapeHtml(vehicle.getSeries()) + "</li>");
                out.println("</ul>");
            }
        }
        out.println("<p><a href='" + request.getContextPath() + "/vehiculos'>Nueva búsqueda</a></p>");
        out.println("</body></html>");
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<","&lt;").replace(">","&gt;")
                .replace("\"","&quot;").replace("'", "&#x27;");
    }

    @Override
    public void destroy(){
        message = "This servlet is not running";
    }

}

