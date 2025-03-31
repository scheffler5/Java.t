/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Financeiro;
import SYS.JDBC.ConexaoBanco;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author gabri
 */
public class FinanceiroDAO {
    private Connection conn;
    
    public FinanceiroDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(Financeiro obj){
        try {
            String sql = "insert into financeiro(Notas,Valor)"
                    + "Values(?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNotas());
            stmt.setFloat(2, obj.getValor());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Nota cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de cadastro do Convenio"+e);
        }
    }
    public List<Financeiro>listar(){
        List<Financeiro> lista = new ArrayList<>();
        try {
            String sql = "SELECT SUM(valor) AS total_valor " 
                         +"FROM financeiro ";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Financeiro obj = new Financeiro();
                obj.setValor(rs.getFloat("total_valor"));
                
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
}
