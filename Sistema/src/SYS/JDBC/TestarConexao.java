/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SYS.JDBC;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class TestarConexao {
    
    public static void main(String[] args) {
        
    
        try {
            new ConexaoBanco().pegarConexao();
            JOptionPane.showMessageDialog(null, "conectado com sucesso ao banco de dados!");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"Erro na conexao com o banco"+ e.getMessage());
        } 
    }
}
