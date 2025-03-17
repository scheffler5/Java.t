/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Antibiotico;
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
public class AntibioticoDAO {
    private Connection conn;
    
    public AntibioticoDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public List<Antibiotico>listar(){
        List<Antibiotico> lista = new ArrayList<>();
        try {
            String sql = "Select * from antibiotico";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Antibiotico obj = new Antibiotico();
                obj.setID(rs.getInt("ID"));
                obj.setNome(rs.getString("Nome"));
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<Antibiotico>Filtrar(String user){
        List<Antibiotico> lista = new ArrayList<>();
        try {
            String sql = "Select * from antibiotico where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Antibiotico obj = new Antibiotico();
                obj.setID(rs.getInt("ID"));
                obj.setNome(rs.getString("Nome"));
                
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Filtrar a lista"+e);
        }
        return null;
    }
}
