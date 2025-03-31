/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Antibiotico;
import Model.Medicamentos;
import Model.Prescricao;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;           // Para usar a conexão com o banco de dados
import java.sql.PreparedStatement;    // Para usar o PreparedStatement
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    public void Editar(Prescricao obj) throws SQLException {
    String sql = "UPDATE prescmedica SET Medicamentos = ?, Antibioticos = ?, Frequencia = ? WHERE Prescricao = ?";

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
        
        stmt.setInt(3, obj.getFrequencia()); 
        stmt.setInt(4, obj.getPrescricao());

        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao editar prescrição: " + e.getMessage());
    }
}

    public Prescricao BuscarPorMedicamento(int prescricao, int medicamento) {
    String sql = "SELECT * FROM prescmedica WHERE Prescricao = ? AND Medicamentos = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, prescricao);
        stmt.setInt(2, medicamento);
        
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Prescricao p = new Prescricao();
            p.setMedicamentos(rs.getInt("Medicamentos"));
            p.setFrequencia(rs.getInt("Frequencia"));
            return p;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar medicamento: " + e.getMessage());
    }
    return null;
}

public Prescricao BuscarPorAntibiotico(int prescricao, int antibiotico) {
    String sql = "SELECT * FROM prescmedica WHERE Prescricao = ? AND Antibioticos = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, prescricao);
        stmt.setInt(2, antibiotico);
        
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Prescricao p = new Prescricao();
            p.setAntibioticos(rs.getInt("Antibioticos"));
            p.setFrequencia(rs.getInt("Frequencia"));
            return p;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar antibiótico: " + e.getMessage());
    }
    return null;
}

    public List<Prescricao> listarMedicamentos(String prescricaoID) {
    List<Prescricao> listaMedicamentos = new ArrayList<>();
    String sql = "SELECT p.Medicamentos, m.Nome , p.Frequencia, p.Prescricao "
               + "FROM prescmedica p "
               + "JOIN medicamentos m ON p.Medicamentos = m.ID "
               + "WHERE p.Prescricao = ? AND p.Medicamentos IS NOT NULL AND p.Antibioticos IS NULL";
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, prescricaoID); 
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Prescricao obj = new Prescricao();
                
                obj.setMedi(rs.getString("Nome"));
                obj.setPrescricao(rs.getInt("Prescricao"));
                obj.setMedicamentos(rs.getInt("Medicamentos"));
                obj.setFrequencia(rs.getInt("Frequencia"));
                
                
                
                listaMedicamentos.add(obj);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar medicamentos: " + e);
    }
    return listaMedicamentos;
}



    public List<Prescricao> listarAntibioticos(String prescricaoID) {
    List<Prescricao> listaAntibioticos = new ArrayList<>();
    String sql = "SELECT p.Antibioticos, m.Nome , p.Frequencia, p.Prescricao "
               + "FROM prescmedica p "
               + "INNER JOIN antibiotico m ON p.Antibioticos = m.ID "
               + "WHERE p.Prescricao = ? AND p.Antibioticos IS NOT NULL AND p.Medicamentos IS NULL";
    
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, prescricaoID); // Agora está correto!
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Prescricao obj = new Prescricao();
               
                obj.setAnti(rs.getString("Nome"));
                obj.setPrescricao(rs.getInt("Prescricao"));
                obj.setAntibioticos(rs.getInt("Antibioticos"));
                obj.setFrequencia(rs.getInt("Frequencia"));
                
                
             
                listaAntibioticos.add(obj);
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar antibióticos: " + e);
    }
    return listaAntibioticos;
}


}
