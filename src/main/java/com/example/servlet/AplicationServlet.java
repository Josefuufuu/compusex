package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name="MainApp", value="/vehiculos")
public class AplicationServlet extends HttpServlet{
    
    private String message;
    @Override
    public void init(){
         message = "Server is running";
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
            // Aquí iría la lógica real de búsqueda (BD o servicio). Se muestra resultado simulado.
            out.println("<p>Buscando vehículo con placa: <strong>" + escapeHtml(placa) + "</strong></p>");
            out.println("<ul>");
            out.println("<li>Placa: " + escapeHtml(placa) + "</li>");
            out.println("<li>Marca: Ejemplo</li>");
            out.println("<li>Modelo: 2020</li>");
            out.println("</ul>");
        }
        out.println("<p><a href='" + request.getContextPath() + "/vehiculos'>Nueva búsqueda</a></p>");
        out.println("</body></html>");
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quot;").replace("'", "&#x27;");
    }

    @Override
    public void destroy(){
        message = "This servlet is not running";
    }
    
}
