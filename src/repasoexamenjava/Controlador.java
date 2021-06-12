/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoexamenjava;

import java.sql.SQLException;
import static repasoexamenjava.ConexionBD.rs;

/**
 *
 * @author josel
 */
public class Controlador {
    
    public static int modificarUsuario(Usuario usuario, String nuevousuario, String nuevaPassword){
        DAOUsuario daoU = new DAOUsuario();
        if(daoU.modificarUsuario(usuario, nuevousuario, nuevaPassword) == 1)
            return 1;
        else
            return 0;
    }
    
    public static int controlarLogin(String username, String password){
        if(DAOUsuario.comprobarLogin(username, password) == 1)
            return 1;
        else
            return 0;
    }
}
