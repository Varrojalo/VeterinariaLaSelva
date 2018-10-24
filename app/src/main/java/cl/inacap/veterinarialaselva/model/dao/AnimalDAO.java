package cl.inacap.veterinarialaselva.model.dao;

import cl.inacap.veterinarialaselva.model.dto.Animal;
import cl.inacap.veterinarialaselva.model.utils.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author marcelo
 */
public class AnimalDAO extends Conexion{
    public void agregarUsuario(Animal animal){
        try{
            this.conectar();
            String sql = "INSERT INTO animal (ID_ANIMAL, NOMBRE_ANIMAL, FOTO_ANIMAL, ESPECIE_ANIMAL, RAZA_ANIMAL, NACIMIENTO_ANIMAL, VACUNA_ANIMAL) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement st = conexion.prepareStatement(sql);
            st.setInt(1, animal.getId());
            st.setString(2, animal.getNombre());
            st.setString(3, animal.getFoto());
            st.setString(4, animal.getEspecie());
            st.setString(5, animal.getRaza());
            st.setDate(6, animal.getNacimiento());
            st.setBoolean(7, animal.getVacuna());

            st.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        finally{
            this.desconectar();
        }
    }

    public ArrayList<Animal> obtenerAnimales(){
        ArrayList<Animal> animales = new ArrayList();
        try{
            this.conectar();
            ResultSet rs;
            String sql = "SELECT * FROM animal";
            PreparedStatement st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getInt(1));
                animal.setNombre(rs.getString(2));
                animal.setFoto(rs.getString(3));
                animal.setEspecie(rs.getString(4));
                animal.setRaza(rs.getString(5));
                animal.setNacimiento(rs.getDate(6));
                animal.setVacuna(rs.getBoolean(7));
                animales.add(animal);
            }
            return animales;
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            return null;
        }
        finally{
            this.desconectar();
        }
    }

    public void eliminarAnimal(int id){
        try{
            this.conectar();
            String sql = "DELETE FROM animal WHERE ID_ANIMAL = ?";
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

    public void eliminarAnimal(Animal animal){
        eliminarAnimal(animal.getId());
    }

    public void actualizarNombre(String nombre, int id){
        try{
            this.conectar();
            String sql = "UPDATE animal SET NOMBRE_ANIMAL  = ? WHERE ID_ANIMAL = ?";
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
}
