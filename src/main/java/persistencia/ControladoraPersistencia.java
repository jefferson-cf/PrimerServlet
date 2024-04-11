package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    
    //Recibirá un parámetro desde el JSP > Servlet > Controladora lógica > Controladora Persistencia
    public void crearUsuario(Usuario usu){
        usuJpa.create(usu);
    }
    
    //Operación READ
    public List<Usuario> traerUsuarios(){
        return usuJpa.findUsuarioEntities();
    }

    public void borrarUsuario(int id_eliminar) {
        try {
            usuJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id_editar_usuario) {
        return usuJpa.findUsuario(id_editar_usuario);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
