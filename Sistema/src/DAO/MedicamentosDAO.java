/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Convenio;
import Model.Medicamentos;
import Model.User;
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
public class MedicamentosDAO {
    private Connection conn;
    
    public MedicamentosDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public List<Medicamentos>listar(){
        List<Medicamentos> lista = new ArrayList<>();
        try {
            String sql = "Select * from medicamentos";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Medicamentos obj = new Medicamentos();
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
    public List<Medicamentos>Filtrar(String user){
        List<Medicamentos> lista = new ArrayList<>();
        try {
            String sql = "Select * from medicamentos where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Medicamentos obj = new Medicamentos();
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
    public List<Medicamentos>listarTudo(){
        List<Medicamentos> lista = new ArrayList<>();
        try {
            String sql = "Select * from medicamentos";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Medicamentos obj = new Medicamentos();
                obj.setNome(rs.getString("Nome"));
                obj.setPreco(rs.getInt("Preco"));
                obj.setQuantidade(rs.getInt("Quantidade"));
                
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<Medicamentos>FiltrarNome(String user){
        List<Medicamentos> lista = new ArrayList<>();
        try {
            String sql = "Select * from medicamentos where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Medicamentos obj = new Medicamentos();
                obj.setNome(rs.getString("Nome"));
                obj.setPreco(rs.getInt("Preco"));
                obj.setQuantidade(rs.getInt("Quantidade"));
                
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Filtrar a lista"+e);
        }
        return null;
    }
    public List<Medicamentos>FiltrarPreco(String user){
        List<Medicamentos> lista = new ArrayList<>();
        try {
            String sql = "Select * from medicamentos where Preco like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Medicamentos obj = new Medicamentos();
                obj.setNome(rs.getString("Nome"));
                obj.setPreco(rs.getInt("Preco"));
                obj.setQuantidade(rs.getInt("Quantidade"));
                
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Filtrar a lista"+e);
        }
        return null;
    }
    public List<Medicamentos>FiltrarQuantidade(String user){
        List<Medicamentos> lista = new ArrayList<>();
        try {
            String sql = "Select * from medicamentos where Quantidade like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Medicamentos obj = new Medicamentos();
                obj.setNome(rs.getString("Nome"));
                obj.setPreco(rs.getInt("Preco"));
                obj.setQuantidade(rs.getInt("Quantidade"));
                
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Filtrar a lista"+e);
        }
        return null;
    }
    public void Salvar(Medicamentos obj){
        try {
            String sql = "insert into medicamentos(Nome,Preco,Quantidade)"
                    + "Values(?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setFloat(2, obj.getPreco());
            stmt.setFloat(3, obj.getQuantidade());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Medicamento cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro de cadastro de Usuario"+e);
        }
    }
}
