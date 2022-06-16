package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class Conexion {

    public Connection conectar = null;
    public String usuario = "miguel";
    public String contraseña = "123abc";
    public String bd = "SistemaVentasAM";
    public String ip = "localhost";
    public String puerto = "1433";

    //String cadena = "jdbc:sqlserver://"+ip +":"+puerto+"/"+bd;
    public Connection establecerConexion() {

        try {
            String cadena = "jdbc:sqlserver://localhost:" + puerto + ";" + "databaseName=" + bd;
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "se conecto correctamente a la base de datos");
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        return conectar;
    }
    
    public void close(Connection c) throws SQLException{
        c.close();
    }
    public void close(PreparedStatement ps) throws SQLException{
        ps.close();
    }
    public void close(ResultSet rs) throws SQLException{
        rs.close();
    }
}
