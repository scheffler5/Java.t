/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SYS.JDBC;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabri
 */
public class ConexaoBanco {
    final private String url = "jdbc:mysql://localhost/hospi";
    final private String usuario = "root";
    final private String senha = "";
    
    public Connection pegarConexao(){
        try{
            return DriverManager.getConnection(url,usuario,senha);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "erro ao se Conectar com o banco de dados"+e);
        }
return null;
    }
    
}
