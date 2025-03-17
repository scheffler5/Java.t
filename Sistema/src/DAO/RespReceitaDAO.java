/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Profi;
import Model.RespReceita;
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
public class RespReceitaDAO {
    private Connection conn;
    
    public RespReceitaDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(RespReceita obj){
        try {
            String sql = "insert into tbrespreceita(Prontuario_ID,Texto)"
                    + "Values(?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getProntuario());
            stmt.setString(2, obj.getTexto());
            
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Receita Gravada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro na Gravação da classificação de risco"+e);
        }
    }
    public void SalvarPadrao(RespReceita obj){
        try {
            String sql = "insert into tbrespreceita(Texto,Titulo)"
                    + "Values(?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
    
            stmt.setString(1, obj.getTexto());
            stmt.setString(2, obj.getTitulo());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Receita Gravada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro na Gravação da classificação de risco"+e);
        }
    }
    public List<RespReceita>listar(){
        List<RespReceita> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbrespreceita WHERE Prontuario_ID is null;";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                RespReceita obj = new RespReceita();
                obj.setID(rs.getInt("ID"));
                obj.setTitulo(rs.getString("Titulo"));
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<RespReceita>Filtrar(String user){
        List<RespReceita> lista = new ArrayList<>();
        try {
            String sql = "Select * from tbrespreceita where Titulo like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                RespReceita obj = new RespReceita();
                obj.setID(rs.getInt("ID"));
                obj.setTitulo(rs.getString("Titulo"));
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    } 
    public RespReceita BuscarTexto(String user){
        try {
            String aql = "SELECT * FROM tbrespreceita WHERE Titulo = ? ";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,user);
            ResultSet rs = stmt.executeQuery();
            RespReceita obj = new RespReceita();
            if(rs.next()){
                obj.setID(rs.getInt("ID"));
                obj.setTitulo(rs.getString("Titulo"));
                obj.setTexto(rs.getString("Texto"));
                
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Cliente  "+ e);
        }
        return null;
    }
}
