/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.RespClassificacao;
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
public class RespClassiciacaoDAO {
    private Connection conn;
    
    public RespClassiciacaoDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(RespClassificacao obj){
        try {
            String sql = "insert into tbrespclassificacao(Pressao,Prontuario_ID,Batimentos,Glicose,Temperatura,Sintomas,Altura,Peso,IMC)"
                    + "Values(?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getPressao());
            stmt.setInt(2, obj.getProntuario_ID());
            stmt.setString(3, obj.getBatimentos());
            stmt.setString(4, obj.getGlicose());
            stmt.setString(5, obj.getTemperatura());
            stmt.setString(6, obj.getSintomas());
            stmt.setString(7, obj.getAltura());
            stmt.setString(8, obj.getPeso());
            stmt.setString(9, obj.getIMC());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Classificacao de Risco Gravada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro na Gravação da classificação de risco"+e);
        }
    }
    
    public RespClassificacao Buscar(String user){
        try {
            String sql = "Select * from tbrespclassificacao where Prontuario_ID = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,user);
            ResultSet rs = stmt.executeQuery();
            RespClassificacao obj = new RespClassificacao();
            if(rs.next()){
                obj.setID(rs.getInt("id"));
                obj.setAltura(rs.getString("Altura"));
                obj.setBatimentos(rs.getString("Batimentos"));
                obj.setGlicose(rs.getString("Glicose"));
                obj.setIMC(rs.getString("IMC"));
                obj.setPeso(rs.getString("Peso"));
                obj.setPressao(rs.getString("Pressao"));
                obj.setSintomas(rs.getString("Sintomas"));
                obj.setTemperatura(rs.getString("Temperatura"));
                obj.setProntuario_ID(rs.getInt("Prontuario_ID"));
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
}
