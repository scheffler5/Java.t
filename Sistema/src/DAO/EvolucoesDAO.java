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
public class EvolucoesDAO {
    private Connection conn;
    
    public EvolucoesDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(Evolucoes obj){
        try {
            String sql = "insert into evolucao"
                    + "Values(?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getDocumentos());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Anaminese cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a anamisense"+e);
        }
    }
    
        public Evolucoes BuscarConvenio(String documentos){
        try {
            String aql = "Select * from evolucao where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,documentos);
            ResultSet rs = stmt.executeQuery();
            Evolucoes obj = new Evolucoes();
            if(rs.next()){
                obj.setID(rs.getInt("ID"));
                obj.setDocumentos(rs.getString("Documentos"));
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Documentos para Anaminese  "+ e);
        }
        return null;
    }
     public List<Evolucoes>listar(){
        List<Evolucoes> lista = new ArrayList<>();
        try {
            String sql = "Select * from evolucao";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Evolucoes obj = new Evolucoes();
                obj.setID(rs.getInt("ID"));
                obj.setDocumentos(rs.getString("Documentos"));
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<Evolucoes>ListarAnamnese(){
        List<Evolucoes> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM evolucao WHERE Documentos LIKE '%Anamnese - Pronto Socorro%' OR Documentos LIKE '%Classificação de Risco%'";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Evolucoes obj = new Evolucoes();
                obj.setID(rs.getInt("ID"));
                obj.setDocumentos(rs.getString("Documentos"));
                
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Filtrar a lista"+e);
        }
        return null;
    }    
    public void Editar(Evolucoes obj){
        try {
            String sql = "update evolucao set Documentos=? where ID=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getDocumentos());
            stmt.setInt(2, obj.getID());
            

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Documento Editado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de Edição dos documentos"+e);
        }
    }    
    public Evolucoes BuscarConvenioCompleto(String documentos){
        try {
            String aql = "Select * from evolucao where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,documentos);
            ResultSet rs = stmt.executeQuery();
            Evolucoes obj = new Evolucoes();
            if(rs.next()){
                obj.setDocumentos(rs.getString("Documentos"));
                
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar CDC Pela CDCDAO  "+ e);
        }
        return null;
    }
    public List<Evolucoes>Filtrar(String user){
        List<Evolucoes> lista = new ArrayList<>();
        try {
            String sql = "Select * from evolucao where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Evolucoes obj = new Evolucoes();
                obj.setID(rs.getInt("ID"));
                obj.setDocumentos(rs.getString("Nome"));
                
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Filtrar a lista"+e);
        }
        return null;
    }    
}
