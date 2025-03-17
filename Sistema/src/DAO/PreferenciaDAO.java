/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Convenio;
import Model.Preferencia;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


    
public class PreferenciaDAO {
    private Connection conn;
    
    public PreferenciaDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(Preferencia obj){
        try {
            String sql = "insert into preferencia(Nome)"
                    + "Values(?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Preferencia cadastrada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de cadastro de preferancia"+e);
        }
    }
    
        public Preferencia BuscarPreferencia(String preferencia){
        try {
            String aql = "Select * from preferencia where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,preferencia);
            ResultSet rs = stmt.executeQuery();
            Preferencia obj = new Preferencia();
            if(rs.next()){
                obj.setID(rs.getInt("ID"));
                obj.setNome(rs.getString("Nome"));
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Preferencia Pela PreferenciaDAO  "+ e);
        }
        return null;
    }
     public List<Preferencia>listar(){
        List<Preferencia> lista = new ArrayList<>();
        try {
            String sql = "Select * from preferencia";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Preferencia obj = new Preferencia();
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
    public List<Preferencia>Filtrar(String user){
        List<Preferencia> lista = new ArrayList<>();
        try {
            String sql = "Select * from preferencia where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Preferencia obj = new Preferencia();
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
    public void Editar(Preferencia obj){
        try {
            String sql = "update preferencia set Nome=? where ID=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            
            stmt.setInt(3, obj.getID());
            

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Preferencia Editado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de Edição de Preferencia"+e);
        }
    }    
    public Preferencia BuscarConvenioCompleto(String Convenio){
        try {
            String aql = "Select * from preferencia where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Convenio);
            ResultSet rs = stmt.executeQuery();
            Preferencia obj = new Preferencia();
            if(rs.next()){
                obj.setNome(rs.getString("Nome"));
                
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Preferencia Pela ConvenioDAO  "+ e);
        }
        return null;
    }   
        
        
        
        
        
        
        
        
    }

