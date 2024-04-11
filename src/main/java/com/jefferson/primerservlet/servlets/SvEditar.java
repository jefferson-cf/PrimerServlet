
package com.jefferson.primerservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Petición para obtener los datos del usuario elegido de la BD
        int id_editar_usuario = Integer.parseInt(request.getParameter("id_usuario_edit"));
        // Envía el parámetro del ID (logica > persistencia > BD) y lo almacena en una variable tipo Usuario
        Usuario usu = control.traerUsuario(id_editar_usuario);
        // Asignamos el ArrayList a la sesión actual
        HttpSession misesion = request.getSession();
        misesion.setAttribute("usuEditar", usu);
        // Redirecciona al usuario a la página editar
        response.sendRedirect("editar.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Recibo los parámetros desde el JSP index
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");
        
        // Creo un objeto vacío y le voy agregando los parámetros
        Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");
        usu.setDni(dni);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setTelefono(telefono);
        
        // Envío los parámetros a la función crearUsuario del Servlet a la controladora lógica
        control.editarUsuario(usu);
        
        // Redirecciono a la página de index
        response.sendRedirect("index.jsp");
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
