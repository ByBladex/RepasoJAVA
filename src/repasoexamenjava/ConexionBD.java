/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoexamenjava;

import java.sql.*;

/**
 *
 * @author josel
 */
public class ConexionBD {
    static Connection conn = null;
    static Statement st = null;
    static ResultSet rs = null;
    static String bd = "login";
    static String user = "login";
    static String password = "login";
    static String url = "jdbc:mysql://localhost/"+bd+"?serverTimezone=Europe/Madrid";
    
    public static Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        }
        catch(ClassNotFoundException ex){
            System.out.println("Imposible acceder al driver MYSQL");
        }
        catch(SQLException ex){
            System.out.println("Error en la ejecución SQL: "+ex.getMessage());
        }
        return conn;
    }
    
    public static ResultSet queryUsuarios(){
        conn = ConexionBD.getConexion();
        try{
            st = conn.createStatement();
        }
        catch(SQLException ex){
            System.out.println("Error en la ejeción SQL: "+ex.getMessage());
        }
        
        try{
            rs = st.executeQuery("select * from usuario");
        }
        catch(SQLException ex){
            System.out.println("Error en la ejecución SQL: "+ex.getMessage());
        }
        return rs;
    }
    
    public static int modificarUsuario(Usuario usuario, String nuevousername, String nuevapassword){
        conn = ConexionBD.getConexion();
        try{
            st = conn.createStatement();
        }
        catch(SQLException ex){
            System.out.println("Error en la ejecución SQL: "+ex.getMessage());
            return 0;
        }
        
        try{
            st.executeUpdate("UPDATE usuario SET username='"+nuevousername+"', password='"+nuevapassword+"' WHERE idusuario='"+usuario.getId()+"'");
        }
        catch(SQLException ex){
            System.out.println("Error en la ejecución SQL: "+ex.getMessage());
            return 0;
        }
        return 1;
    }
    
    public static void cerrarConexion(){
        try{
            rs.close();
            st.close();
            conn.close();
        }
        catch(SQLException ex){
            System.out.println("Error al cerrar la conexión con la BD: "+ex.getMessage());
        }
    }
}
