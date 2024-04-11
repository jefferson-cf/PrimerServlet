<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos del cliente</h1>
        <form action="SvUsuarios" method="POST">
            <p><label>DNI:</label><input type="text" name="dni"></p>
            <p><label>Nombre:</label><input type="text" name="nombre"></p>
            <p><label>Apellido:</label><input type="text" name="apellido"></p>
            <p><label>Teléfono:</label><input type="text" name="telefono"></p>
            <button type="submit">Enviar</button>
        </form>
        
        <h1>Ver lista de usuarios</h1>
        <p>Para ver los datos de los usuarios cargados haga click en el siguiente botón</p>
        <form action="SvUsuarios" method="GET">
            <button type="submit">Mostrar Usuarios</button>
        </form>
        
        <h1>Eliminar Usuario</h1>
        <p>Ingrese el ID del usuario que desea eliminar</p>
        <form action="SvEliminar" method="POST">
            <p><label>ID:</label><input type="text" name="id_usuario"></p>
            <button type="submit">Eliminar usuario</button>
        </form>
        
        <h1>Editar Usuario</h1>
        <p>Ingrese el ID del usuario que desea editar</p>
        <form action="SvEditar" method="GET">
            <p><label>ID:</label><input type="text" name="id_usuario_edit"></p>
            <button type="submit">Editar usuario</button>
        </form>
        
    </body>
</html>
