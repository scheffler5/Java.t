/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Exames;
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
public class ExamesDAO {
    private Connection conn;
    
    public ExamesDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public Exames BuscarUser(String user){
        try {
            String aql = "Select * from exame where ID =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,user);
            ResultSet rs = stmt.executeQuery();
            Exames obj = new Exames();
            if(rs.next()){
                obj.setID(rs.getInt("ID"));
                obj.setNome(rs.getString("Nome"));

            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Exame  "+ e);
        }
        return null;
    }
    public List<Exames>listar(){
        List<Exames> lista = new ArrayList<>();
        try {
            String sql = "Select * from exame";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Exames obj = new Exames();
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
    public List<Exames>Filtrar(String user){
        List<Exames> lista = new ArrayList<>();
        try {
            String sql = "Select * from exame where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Exames obj = new Exames();
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
}
