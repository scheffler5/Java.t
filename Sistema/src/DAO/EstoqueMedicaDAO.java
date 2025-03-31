/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Evolucoes;
import Model.CDC;
import Model.Convenio;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author gabri
 */
public class EstoqueMedicaDAO {
    private Connection conn;
    
    public EstoqueMedicaDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
}
