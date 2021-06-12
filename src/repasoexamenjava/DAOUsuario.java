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
public class DAOUsuario {
    
    private static Connection conn;
    private static Usuario usuarioLogueado;
    
    DAOUsuario(){
        conn = ConexionBD.getConexion();
    }
    
    public static int comprobarLogin(String username, String password){
        try {
            ResultSet rs = ConexionBD.queryUsuarios();
            while (rs.next()){ 
                Integer id = rs.getInt("idusuario");
                String usuario = rs.getString("username");
                String contraseña = rs.getString("password");
                if(usuario.equals(username) && contraseña.equals(password)){
                    usuarioLogueado = new Usuario(id,usuario,password);
                    System.out.println("Usuario logueado");
                    return 1;
                }
            }
        } 
        catch (SQLException ex) {
            System.out.println("Error en la ejecución SQL: " + ex.getMessage());
            ex.printStackTrace();
            return 0;
        }
        return 0;
    }
    
    public Usuario getUsuarioLogueado(){
        return this.usuarioLogueado;
    }
    
    public void cerrarSesion(){
        System.out.println("Sesion cerrada");
        this.usuarioLogueado = null;
    }
    
    public int modificarUsuario(Usuario usuario, String nuevousuario, String nuevapassword){
        conn = ConexionBD.getConexion();
        if(ConexionBD.modificarUsuario(usuario, nuevousuario, nuevapassword) == 1){
            usuarioLogueado.setUsername(nuevousuario);
            usuarioLogueado.setPassword(nuevapassword);
            ConexionBD.cerrarConexion();
            return 1;
        }
        else{
            ConexionBD.cerrarConexion();
            return 0;
        }
    }
}
