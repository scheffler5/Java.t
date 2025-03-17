/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Convenio;
import Model.Pacientes;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConvenioDAO {
    private Connection conn;
    
    public ConvenioDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(Convenio obj){
        try {
            String sql = "insert into convenio(Nome,ValorPorAtendimento)"
                    + "Values(?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getValor());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Convenio cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de cadastro do Convenio"+e);
        }
    }
    
        public Convenio BuscarConvenio(String Convenio){
        try {
            String aql = "Select * from convenio where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Convenio);
            ResultSet rs = stmt.executeQuery();
            Convenio obj = new Convenio();
            if(rs.next()){
                obj.setID(rs.getInt("ID"));
                obj.setNome(rs.getString("Nome"));
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Convenio Pela ConvenioDAO  "+ e);
        }
        return null;
    }
     public List<Convenio>listar(){
        List<Convenio> lista = new ArrayList<>();
        try {
            String sql = "Select * from convenio";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Convenio obj = new Convenio();
                obj.setID(rs.getInt("ID"));
                obj.setNome(rs.getString("Nome"));
                obj.setValor(rs.getString("ValorPorAtendimento"));
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<Convenio>Filtrar(String user){
        List<Convenio> lista = new ArrayList<>();
        try {
            String sql = "Select * from convenio where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Convenio obj = new Convenio();
                obj.setID(rs.getInt("ID"));
                obj.setNome(rs.getString("Nome"));
                obj.setValor(rs.getString("ValorPorAtendimento"));
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Filtrar a lista"+e);
        }
        return null;
    }    
    public void Editar(Convenio obj){
        try {
            String sql = "update Convenio set Nome=?,ValorPorAtendimento=? where ID=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getValor());
            stmt.setInt(3, obj.getID());
            

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Convenio Editado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de Edição do Convenio"+e);
        }
    }    
    public Convenio BuscarConvenioCompleto(String Convenio){
        try {
            String aql = "Select * from convenio where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Convenio);
            ResultSet rs = stmt.executeQuery();
            Convenio obj = new Convenio();
            if(rs.next()){
                obj.setNome(rs.getString("Nome"));
                obj.setValor(rs.getString("ValorPorAtendimento"));
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Convenio Pela ConvenioDAO  "+ e);
        }
        return null;
    }   
        
        
        
        
        
        
        
        
    }





