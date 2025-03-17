/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Prescricao;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;           // Para usar a conexão com o banco de dados
import java.sql.PreparedStatement;    // Para usar o PreparedStatement
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author gabri
 */
public class PrescricaoDAO {
    private Connection conn;
    
    public PrescricaoDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(Prescricao obj) throws SQLException {
        String sql = "INSERT INTO prescmedica (Medicamentos, Antibioticos,Prescricao, Frequencia) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            if (obj.getMedicamentos() != null) {
                stmt.setInt(1, obj.getMedicamentos()); 
            } else {
                stmt.setNull(1, java.sql.Types.INTEGER); 
            }
            if (obj.getAntibioticos() != null) {
                stmt.setInt(2, obj.getAntibioticos()); 
            } else {
            stmt.setNull(2, java.sql.Types.INTEGER); 
            }
            
            stmt.setInt(3, obj.getPrescricao());
            stmt.setInt(4, obj.getFrequencia());
            stmt.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Prescrição: " + e.getMessage());
        }}
    
}
