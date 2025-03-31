/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.EstoqueMedi;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author gabri
 */
public class EstoqueMediDAO {
    private Connection conn;
    
    public EstoqueMediDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    
    public void Salvar(EstoqueMedi obj) throws SQLException {
        try {
        String sql = "INSERT INTO estoquemedi (Medicamentos, CDC, Fornecedor, Quantidade) VALUES (?, ?, ?, ?)";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getMedicamentos());
            stmt.setInt(2, obj.getCDC());
            stmt.setInt(3, obj.getFornecedor());
            stmt.setFloat(4, obj.getQuantidade());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Lançamentos Realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Prescrição: " + e.getMessage());
        }}
    public void SalvarBaixa(EstoqueMedi obj) throws SQLException {
        try {
        String sql = "INSERT INTO estoquemedi (Medicamentos, CDC) VALUES (?, ?)";

        java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getMedicamentos());
            stmt.setInt(2, obj.getCDC());

            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Lançamentos Realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Prescrição: " + e.getMessage());
        }}
}
