/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import javax.swing.JOptionPane;
import Model.Pacientes;
import Model.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private Connection conn;
    
    public PacienteDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(Pacientes obj){
        try {
            String sql = "insert into dadospacientes(Nome,DataNascimento,CartaoSUS,CPF,RG,Telefone,Municipio,Endereco,CEP,Pais,Email,Estado,NomeMae,NomePai,EstadoCivil)"
                    + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getDataNascimento());
            stmt.setString(3, obj.getCartaoSus());
            stmt.setString(4, obj.getCPF());
            stmt.setString(5, obj.getRG());            
            stmt.setString(6, obj.getTelefone());
            stmt.setString(7, obj.getMunicipio());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getCEP());
            stmt.setString(10, obj.getPais());
            stmt.setString(11, obj.getEmail());
            stmt.setString(12, obj.getEstado());
            stmt.setString(13, obj.getNomeMae());
            stmt.setString(14, obj.getNomePai());
            stmt.setString(15, obj.getEstadoCivil());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de cadastro do Paciente"+e);
        }
    }
    public Pacientes BuscarPaciente(String Paciente){
        try {
            String aql = "Select * from dadospacientes where Registro =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Paciente);
            ResultSet rs = stmt.executeQuery();
            Pacientes obj = new Pacientes();
            if(rs.next()){
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
    
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Paciente Pela PacienteDAO  "+ e);
        }
        return null;
    }
    public List<Pacientes>listar(){
        List<Pacientes> lista = new ArrayList<>();
        try {
            String sql = "Select * from dadospacientes";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Pacientes obj = new Pacientes();
                obj.setRegistro(rs.getInt("Registro"));
                obj.setNome(rs.getString("Nome"));
                obj.setCPF(rs.getString("CPF"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<Pacientes>Filtrar(String user){
        List<Pacientes> lista = new ArrayList<>();
        try {
            String sql = "Select * from dadospacientes where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Pacientes obj = new Pacientes();
                obj.setRegistro(rs.getInt("Registro"));
                obj.setNome(rs.getString("Nome"));
                obj.setCPF(rs.getString("CPF"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    } 
    
    
    
    public void Editar(Pacientes obj){
        try {
            String sql = "update dadospacientes set Pais=?,Nome=?,DataNascimento=?,CartaoSUS=?,CPF=?,RG=?,Telefone=?,Municipio=?,"
                    + "Endereco=?,CEP=?,NomeMae=?,Estado=?,NomePai=?,EstadoCivil=?,Email=? where Registro=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getPais());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getDataNascimento());
            stmt.setString(4, obj.getCartaoSus());
            stmt.setString(5, obj.getCPF());
            stmt.setString(6, obj.getRG());            
            stmt.setString(7, obj.getTelefone());
            stmt.setString(8, obj.getMunicipio());
            stmt.setString(9, obj.getEndereco());
            stmt.setString(10, obj.getCEP());
            stmt.setString(11, obj.getNomeMae());
            stmt.setString(12, obj.getNomePai());
            stmt.setString(13, obj.getEstado());           
            stmt.setString(14, obj.getEmail());
            stmt.setString(15, obj.getEstadoCivil());
            stmt.setInt(16, obj.getRegistro());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de cadastro do Paciente"+e);
        }
    }
    public Pacientes BuscarPacienteCompleto(String Pacientes){
        try {
            String aql = "Select * from dadosPacientes where CPF =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,Pacientes);
            ResultSet rs = stmt.executeQuery();
            Pacientes obj = new Pacientes();
            if(rs.next()){
                obj.setRegistro(rs.getInt("Registro"));
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSus(rs.getString("CartaoSUS"));
                obj.setCPF(rs.getString("CPF"));
                obj.setRG(rs.getString("RG"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setMunicipio(rs.getString("Municipio"));
                obj.setEndereco(rs.getString("Endereco"));
                obj.setCEP(rs.getString("CEP"));
                obj.setPais(rs.getString("pais"));
                obj.setEstado(rs.getString("Estado"));
                obj.setNomeMae(rs.getString("NomeMae"));
                obj.setNomePai(rs.getString("NomePai"));
                obj.setEstadoCivil(rs.getString("EstadoCivil"));
                obj.setEmail(rs.getString("Email"));   
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar o Paciente  "+ e);
        }
        return null;
    }
    
    
}
