/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.CDC;
import Model.Pacientes;
import Model.PrescricaoModel;
import Model.Prontuario;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class PrescricaoModelDAO {
    private Connection conn;
    
    public PrescricaoModelDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(PrescricaoModel obj) {
    String sqlSelect = "SELECT CDC_ID FROM prontuario WHERE Prontuario = ?";
    String sqlInsert = "INSERT INTO tbprescricao (Prontuario_ID, CDC_ID) VALUES (?, ?)";
    try (PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);
         PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert)) {
        stmtSelect.setInt(1, obj.getProntuario());
        ResultSet rs = stmtSelect.executeQuery();

        int cdcID = 0; 
        if (rs.next()) {
            cdcID = rs.getInt("CDC_ID");
        }
        stmtInsert.setInt(1, obj.getProntuario());
        stmtInsert.setInt(2, cdcID);
        stmtInsert.execute();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao salvar Prescrição: " + e.getMessage());
    }
}
    public PrescricaoModel BuscarConvenio(int Convenio){
        try {
            String aql = "SELECT * FROM tbprescricao WHERE Prontuario_ID = ? ORDER BY ID_Prescricao DESC LIMIT 1;";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setInt(1,Convenio);
            ResultSet rs = stmt.executeQuery();
            PrescricaoModel obj = new PrescricaoModel();
            if(rs.next()){
                obj.setID_prescricao(rs.getInt("ID_Prescricao"));
                obj.setProntuario(rs.getInt("Prontuario_ID"));

            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Prescricao Pela PrescricaoDAO  "+ e);
        }
        return null;
    }
    public List<PrescricaoModel> listar(int prontuario) {
    List<PrescricaoModel> lista = new ArrayList<>();
    String sql = "SELECT " 
         + "pre.Prontuario_ID, "
         + "pa.Nome AS PacienteNome, "
         + "pre.ID_Prescricao "
         + "FROM tbprescricao pre "  
         + "JOIN prontuario p ON p.Prontuario = pre.Prontuario_ID "
         + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
         + "WHERE pre.Prontuario_ID = ? "
         + "ORDER BY pre.ID_Prescricao DESC;"; 

    try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, prontuario);  

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {  
                Prontuario obj = new Prontuario();
                Pacientes dado = new Pacientes();
                PrescricaoModel mo = new PrescricaoModel();

                obj.setProntuario(rs.getInt("pre.Prontuario_ID"));
                mo.setID_prescricao(rs.getInt("ID_Prescricao"));
                dado.setNome(rs.getString("PacienteNome"));

                mo.setID_prontuario(obj);
                mo.setID_Paciente(dado);

                lista.add(mo);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e);
        e.printStackTrace(); 
    }
    return lista;
}
    
    public void Excluir(PrescricaoModel obj){
        try {
            String sql = "delete from tbprescricao where ID_Prescricao=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getID_prescricao());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Usuario Excluido com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir o Usuario"+e);
        }
    }
    public List<PrescricaoModel> listarTudo() {
    List<PrescricaoModel> lista = new ArrayList<>();
    String sql = "SELECT " 
         + "pre.Prontuario_ID, "
         + "pa.Nome AS PacienteNome, "
         + "pre.ID_Prescricao, "
         + "c.CDC, "
         + "pre.CDC_ID "
         + "FROM tbprescricao pre "  
         + "JOIN prontuario p ON p.Prontuario = pre.Prontuario_ID "
         + "JOIN dadospacientes pa ON p.Registro = pa.Registro "
         + "JOIN cdc c ON pre.CDC_ID = c.ID "
         + "WHERE pre.Baixada = 0 "
         + "ORDER BY pre.ID_Prescricao DESC;"; 

    try (java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
        

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) { 
                Prontuario obj = new Prontuario();
                Pacientes dado = new Pacientes();
                PrescricaoModel mo = new PrescricaoModel();
                CDC cdc = new CDC();

                mo.setProntuario(rs.getInt("pre.Prontuario_ID"));
                mo.setID_prescricao(rs.getInt("ID_Prescricao"));
                mo.setPaci(rs.getString("PacienteNome"));
                mo.setCDC(rs.getString("c.CDC"));
                mo.setCDC_ID(rs.getInt("CDC_ID"));
                

                

                lista.add(mo);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao criar a lista: " + e);
        e.printStackTrace(); 
    }
    return lista;
}
    public void Editar(PrescricaoModel obj){
        try {
            String sql = "update tbprescricao set Baixada=? WHERE ID_Prescricao=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, obj.getBaixada());
            stmt.setInt(2, obj.getID_prescricao());
            
            
            stmt.execute();
            stmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao Liberar o Paciente"+e);
        }
    }
    public PrescricaoModel BuscarBaixa(int user){
        try {
            String aql = "Select * from tbprescricao where ID_Prescricao = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setInt(1,user);
            ResultSet rs = stmt.executeQuery();
            PrescricaoModel obj = new PrescricaoModel();
            if(rs.next()){
                obj.setID_prescricao(rs.getInt("ID_Prescricao"));
                obj.setBaixada(rs.getInt("Baixada"));
                
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Cliente  "+ e);
        }
        return null;
    }
}
