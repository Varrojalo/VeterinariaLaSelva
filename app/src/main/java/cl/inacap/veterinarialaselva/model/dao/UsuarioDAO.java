package cl.inacap.veterinarialaselva.model.dao;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cl.inacap.veterinarialaselva.model.utils.Conexion;
import cl.inacap.veterinarialaselva.model.dto.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsuarioDAO extends Conexion{
    private DatabaseReference referenciaBD = FirebaseDatabase.getInstance().getReference();

    public void agregarUsuario(Usuario usuario){
        try{
            this.conectar();
            String sql = "INSERT INTO usuario (ID_USUARIO, NOMBRE_USUARIO, FOTO_USUARIO, CONTRACENA_USUARIO, CORREO_USUARIO) VALUES(?,?,?,?,?)";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, usuario.getId());
            st.setString(2, usuario.getNombre());
            st.setInt(3, usuario.getFoto());
            st.setString(4, usuario.getContracena());
            st.setString(5, usuario.getCorreo());

            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
    }

    public void agregar (Usuario usuario)
    {
        String userId = usuario.getNombre()+usuario.getId();
        referenciaBD.child("usuarios").child(userId).setValue(usuario);
    }

    public ArrayList<Usuario> obtenerUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList();
        try{
            this.conectar();
            ResultSet rs;
            String sql = "SELECT * FROM usuario";
            PreparedStatement st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setFoto(rs.getInt(3));
                usuario.setContracena(rs.getString(4));
                usuario.setCorreo(rs.getString(5));
                usuarios.add(usuario);
            }
            return usuarios;
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            return null;
        }
        finally{
            this.desconectar();
        }
    }

    public void eliminarUsuario(int id){
        try{
            this.conectar();
            String sql = "DELETE FROM usuario WHERE ID_USUARIO = ?";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
    }

    public void eliminarUsuario(Usuario usuario){
        eliminarUsuario(usuario.getId());
    }

    public void eliminar(Usuario usuario)
    {
        String userId = usuario.getNombre()+usuario.getId();
        referenciaBD.child("usuarios").child(userId).removeValue();
    }

    public void actualizarNombre(String nombre, int id){
        try{
            this.conectar();
            String sql = "UPDATE usuario SET NOMBRE_USUARIO  = ? WHERE ID_USUARIO = ?";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, nombre);
            st.setInt(2, id);
            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
    }

    public void actualizarContracenia(String contracenia, int id){
        try{
            this.conectar();
            String sql = "UPDATE usuario SET NOMBRE_USUARIO  = ? WHERE ID_USUARIO = ?";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setString(1, contracenia);
            st.setInt(2, id);
            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
    }

}

