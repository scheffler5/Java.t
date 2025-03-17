/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.CDC;
import Model.Prontuario;
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
public class CDCDAO {
    private Connection conn;
    
    public CDCDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(CDC obj){
        try {
            String sql = "insert into cdc (CDC)"
                    + "Values(?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getCDC());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "CDC cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de cadastro do CDC"+e);
        }
    }
    
        public CDC BuscarConvenio(String Convenio){
        try {
            String aql = "Select * from cdc where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Convenio);
            ResultSet rs = stmt.executeQuery();
            CDC obj = new CDC();
            if(rs.next()){
                obj.setID(rs.getInt("ID"));
                obj.setCDC(rs.getString("CDC"));
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar CDC Pela CDCDAO  "+ e);
        }
        return null;
    }
     public List<CDC>listar(){
        List<CDC> lista = new ArrayList<>();
        try {
            String sql = "Select * from cdc";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                CDC obj = new CDC();
                obj.setID(rs.getInt("ID"));
                obj.setCDC(rs.getString("CDC"));
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<CDC>Filtrar(String user){
        List<CDC> lista = new ArrayList<>();
        try {
            String sql = "Select * from cdc where CDC like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                CDC obj = new CDC();
                obj.setID(rs.getInt("ID"));
                obj.setCDC(rs.getString("CDC"));
                
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Filtrar a lista"+e);
        }
        return null;
    }    
    public void Editar(CDC obj){
        try {
            String sql = "update cdc set CDC=? where ID=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getCDC());
            stmt.setInt(2, obj.getID());
            

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "CDC Editado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de Edição do CDC"+e);
        }
    }    
    public CDC BuscarConvenioCompleto(String Convenio){
        try {
            String aql = "Select * from cdc where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Convenio);
            ResultSet rs = stmt.executeQuery();
            CDC obj = new CDC();
            if(rs.next()){
                obj.setCDC(rs.getString("Nome"));
                
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar CDC Pela CDCDAO  "+ e);
        }
        return null;
    }
    public CDC BuscarLabelCDC(int Convenio){
        try {
            String aql = "SELECT "
                    + "p.Prontuario, "
                    + "pa.CDC "
                    + "FROM prontuario p "
                    + "JOIN cdc pa ON p.cdc_id = pa.ID "
                    + "WHERE p.Prontuario =?";   
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setInt(1,Convenio);
            ResultSet rs = stmt.executeQuery();
            CDC obj = new CDC();
            Prontuario pro = new Prontuario();
            if(rs.next()){
                pro.setProntuario(rs.getInt("Prontuario") );
                obj.setCDC(rs.getString("CDC"));
                obj.setPront(pro);
                
                
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar CDC Pela CDCDAO  "+ e);
        }
        return null;
    }
    
   
}
