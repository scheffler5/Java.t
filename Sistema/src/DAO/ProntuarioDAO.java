/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Formularios.frmCadastroDadosPaciente;
import Model.Prontuario;
import Model.User;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ProntuarioDAO {
    private Connection conn;
    
    public ProntuarioDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public Prontuario BuscarPaciente(String Prontuario){
        try {
            String aql = "Select * from prontuario where Registro =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Prontuario);
            ResultSet rs = stmt.executeQuery();
            Prontuario obj = new Prontuario();
            if(rs.next()){
                obj.setRegistro(rs.getInt("Registro"));
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar  Registro  "+ e);
            }
        return null;
    }
    
    
    
    
    
}
