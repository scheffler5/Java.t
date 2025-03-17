/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.AnamneseMedica;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author gabri
 */
public class AnamneseMedicaDAO {
    private Connection conn;
    public AnamneseMedicaDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(AnamneseMedica obj){
        try {
            String sql = "insert into tbrespanamnesia(Diagnostico, Prontuario_ID, ProcedimentoClinico, Encaminhamento)"
                    + "Values(?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getDiagnostico());
            stmt.setInt(2, obj.getProntuario_ID());
            stmt.setString(3, obj.getProcedimentoClinico());
            stmt.setString(4, obj.getEncaminhamento());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Evolução Medica cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a Evolção Medica"+e);
        }
    }
    
    
    
    
}
