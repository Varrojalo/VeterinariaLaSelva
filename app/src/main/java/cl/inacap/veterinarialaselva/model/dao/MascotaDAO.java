package cl.inacap.veterinarialaselva.model.dao;

import cl.inacap.veterinarialaselva.model.utils.Conexion;
import cl.inacap.veterinarialaselva.model.dto.Mascota;
import cl.inacap.veterinarialaselva.model.dto.Usuario;
import cl.inacap.veterinarialaselva.model.dto.Animal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author marcelo
 */
public class MascotaDAO extends Conexion{
    public void agregarUsuario(Mascota mascota){
        try{
            this.conectar();
            String sql = "INSERT INTO mascota (ID_USUARIO, ID_ANIMAL, FECHA_ADOPCION_MASCOTA) VALUES(?,?,?)";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, mascota.getUsuario().getId());
            st.setInt(2, mascota.getAnimal().getId());
            st.setDate(3, mascota.getFechaAdopcion());

            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList();
        try{
            this.conectar();
            ResultSet rs;
            String sql = "SELECT * FROM mascota "
                    + "INNER JOIN usuario ON mascota.ID_USUARIO = usuario.ID_USUARIO "
                    + "INNER JOIN animal ON mascota.ID_ANIMAL = animal.ID_ANIMAL;";
            PreparedStatement st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setFechaAdopcion(rs.getDate(3));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(4));
                usuario.setNombre(rs.getString(5));
                usuario.setFoto(rs.getString(6));
                usuario.setContracena(rs.getString(7));
                usuario.setCorreo(rs.getString(8));
                mascota.setUsuario(usuario);
                Animal animal = new Animal();
                animal.setId(rs.getInt(9));
                animal.setNombre(rs.getString(10));
                animal.setFoto(rs.getString(11));
                animal.setEspecie(rs.getString(12));
                animal.setRaza(rs.getString(13));
                animal.setNacimiento(rs.getDate(14));
                animal.setVacuna(rs.getBoolean(15));
                mascota.setAnimal(animal);
            }
            return mascotas;
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            return null;
        }
        finally{
            this.desconectar();
        }
    }

    public void eliminarMascota(int idUsuario, int idAnimal){
        try{
            this.conectar();
            String sql = "DELETE FROM mascota WHERE ID_USUARIO = ?, ID_ANIMAL = ?";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, idUsuario);
            st.setInt(2, idAnimal);

            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
    }

    public void eliminarMascota(Mascota mascota){
        eliminarMascota(mascota.getAnimal().getId() , mascota.getUsuario().getId());
    }
}

