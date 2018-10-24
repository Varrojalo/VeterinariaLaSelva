package cl.inacap.veterinarialaselva.model.dao;

import cl.inacap.veterinarialaselva.model.utils.Conexion;
import cl.inacap.veterinarialaselva.model.dto.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author marcelo
 */
public class ProductoDAO extends Conexion{
    public ArrayList<Producto> obtenerProductos(){
        ArrayList<Producto> productos = new ArrayList();
        try{
            this.conectar();
            ResultSet rs;
            String sql = "SELECT * FROM producto";
            PreparedStatement st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCodigo(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setMarca(rs.getString(3));
                producto.setPrecio(rs.getInt(4));
                producto.setStock(rs.getInt(5));
                productos.add(producto);
            }
            return productos;
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            return null;
        }
        finally{
            this.desconectar();
        }
    }
}