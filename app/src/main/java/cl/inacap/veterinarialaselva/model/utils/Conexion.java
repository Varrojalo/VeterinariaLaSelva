package cl.inacap.veterinarialaselva.model.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author marcelo
 */
public class Conexion {
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String SERVER = "localhost";
    private final String DATABASE = "veterinaria";

    protected Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public boolean conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String cadena = "jdbc:mysql://"+SERVER+":9999/"+DATABASE;
            this.conexion = DriverManager.getConnection(cadena, USER, PASSWORD);
            return true;
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            return false;
        }
    }

    public boolean desconectar(){
        try{
            this.conexion.close();
            return true;
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            return false;
        }
    }
}
