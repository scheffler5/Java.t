/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.SolicitacaoExames;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;           
import java.sql.PreparedStatement;    
import java.sql.SQLException;         
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class SolicitacaoExamesDAO {
    private Connection conn;
    
    public SolicitacaoExamesDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(SolicitacaoExames obj) {
        String sql = "INSERT INTO solicitacaoexame (Pront, ID_exame) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, obj.getPront());
            stmt.setInt(2, obj.getID_exame());
            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar exame: " + e.getMessage());
        }
    }
}
