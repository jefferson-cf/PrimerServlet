<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%> <!-- Importar la clase List -->
<%@page import="logica.Usuario"%> <!-- Importar la clase Usuario -->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Lista de Usuarios registrados</h1>
        <%
            List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
            int cont = 1;
            for(Usuario usu : listaUsuarios){
        %>
        
                <p><b>Usuario N° <%=cont%></b></p>
                <p>ID: <%=usu.getId()%></p>
                <p>DNI: <%=usu.getDni()%></p>
                <p>Nombre: <%=usu.getNombre()%></p>
                <p>Apellido: <%=usu.getApellido()%></p>
                <p>Teléfono: <%=usu.getTelefono()%></p>
                <p>-------------------------------------</p>
                <%cont++;%>
        
        <% } %>
        
    </body>
</html>

