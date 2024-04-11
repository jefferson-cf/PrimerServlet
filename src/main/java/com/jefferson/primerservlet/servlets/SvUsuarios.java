package com.jefferson.primerservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Petición para mostrar todos los usuarios de la BD
        List<Usuario> listaUsuarios = new ArrayList<>(); // Creamos un ArrayList de tipo Usuario para almacenar los usuarios de la BD 
        // Almacenamos los datos en el ArrayList (Controladora logica > Controladora Persistencia > BD y viceversa)
        listaUsuarios = control.traerUsuarios(); 
        HttpSession misesion = request.getSession(); // Guardamos los datos de la sesión
        misesion.setAttribute("listaUsuarios", listaUsuarios); // Asignamos el ArrayList a la sesión actual
        response.sendRedirect("mostrarUsuarios.jsp"); // Enviamos al usuario a la página de mostrarUsuarios
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
        Usuario usu = new Usuario();
        usu.setDni(dni);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setTelefono(telefono);
        
        // Envío los parámetros a la función crearUsuario del Servlet a la controladora lógica
        control.crearUsuario(usu);
        
        // Redirecciono a la página de index
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
