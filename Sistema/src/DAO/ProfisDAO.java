/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Model.Profi;
import Model.User;
import SYS.JDBC.ConexaoBanco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProfisDAO {
    private Connection conn;
    
    public ProfisDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(Profi obj){
        try {
            String sql = "insert into profissionais(Nome,CartaoSUS,IDCredencial,IDespecialidade,DataNascimento,CPF,Função, Salario,Ativo)"
                    + "Values(?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCartaoSUS());
            stmt.setString(3, obj.getIDCredencial());
            stmt.setString(4, obj.getIDespecialidade());
            stmt.setString(5, obj.getDataNascimento());
            stmt.setString(6, obj.getCPF());
            stmt.setString(7, obj.getFuncao());
            stmt.setFloat(8, obj.getSalario());
            stmt.setInt(9, obj.getSituacao());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Profissional cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro de cadastro de Profissional"+e);
        }
    }
    public void Editar(Profi obj){
        try {
            String sql = "update profissionais set Nome=?, CartaoSUS=?, IDCredencial=?, IDespecialidade=?, DataNascimento=?, CPF=?, Função=?, Salario=?, Ativo=? where IDProf=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCartaoSUS());
            stmt.setString(3, obj.getIDCredencial());
            stmt.setString(4, obj.getIDespecialidade());
            stmt.setString(5, obj.getDataNascimento());
            stmt.setString(6, obj.getCPF());
            stmt.setString(7, obj.getFuncao());
            stmt.setFloat(8, obj.getSalario());
            stmt.setInt(9, obj.getSituacao());
            
            stmt.setInt(10, obj.getIDProf());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Profissional Editado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao Editar o Profissional"+e);
        }
    }
    public void Excluir(Profi obj){
        try {
            String sql = "delete from profissionais where IDProf=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getIDProf());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Profissional Excluido com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir o Profissional"+e);
        }
    }
    public Profi BuscarProf(String user){
        try {
            String aql = "SELECT * FROM profissionais WHERE IDProf = ? ";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,user);
            ResultSet rs = stmt.executeQuery();
            Profi obj = new Profi();
            if(rs.next()){
                obj.setIDProf(rs.getInt("IDProf"));
             
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSUS(rs.getString("CartaoSUS"));
                obj.setCPF(rs.getString("CPF"));
                obj.setIDCredencial(rs.getString("IDCredencial"));
                obj.setIDespecialidade(rs.getString("IDespecialidade"));
                obj.setFuncao(rs.getString("Função"));
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Cliente  "+ e);
        }
        return null;
    }
    public List<Profi>listar(){
        List<Profi> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM profissionais WHERE IDCredencial = 'CRM';";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Profi obj = new Profi();
                obj.setIDProf(rs.getInt("IDProf"));
                
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSUS(rs.getString("CartaoSUS"));
                obj.setCPF(rs.getString("CPF"));
                obj.setIDCredencial(rs.getString("IDCredencial"));
                obj.setIDespecialidade(rs.getString("IDespecialidade"));
                obj.setFuncao(rs.getString("Função"));
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<Profi>Filtrar(String user){
        List<Profi> lista = new ArrayList<>();
        try {
            String sql = "Select * from profissionais where Nome like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                Profi obj = new Profi();
                obj.setIDProf(rs.getInt("IDProf"));
                
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSUS(rs.getString("CartaoSUS"));
                obj.setCPF(rs.getString("CPF"));
                obj.setIDCredencial(rs.getString("IDCredencial"));
                obj.setIDespecialidade(rs.getString("IDespecialidade"));
                obj.setFuncao(rs.getString("Função"));
                obj.setSalario(rs.getFloat("Salario"));
                obj.setSituacao(rs.getInt("Ativo"));
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    } 
    public Profi BuscarProfTudo(String user){
        try {
            String aql = "SELECT * FROM profissionais WHERE CPF like  ? ";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,user);
            ResultSet rs = stmt.executeQuery();
            Profi obj = new Profi();
            if(rs.next()){
                obj.setCPF(rs.getString("CPF"));
                obj.setIDProf(rs.getInt("IDProf"));
             
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSUS(rs.getString("CartaoSUS"));
                
                obj.setIDCredencial(rs.getString("IDCredencial"));
                obj.setIDespecialidade(rs.getString("IDespecialidade"));
                obj.setFuncao(rs.getString("Função"));
                obj.setSalario(rs.getFloat("Salario"));
                obj.setSituacao(rs.getInt("Ativo"));
                
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Cliente  "+ e);
        }
        return null;
    }
    public List<Profi>listarTudo(){
        List<Profi> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM profissionais ";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Profi obj = new Profi();
                obj.setIDProf(rs.getInt("IDProf"));
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSUS(rs.getString("CartaoSUS"));
                obj.setCPF(rs.getString("CPF"));
                obj.setIDCredencial(rs.getString("IDCredencial"));
                obj.setIDespecialidade(rs.getString("IDespecialidade"));
                obj.setFuncao(rs.getString("Função"));
                obj.setSalario(rs.getFloat("Salario"));
                obj.setSituacao(rs.getInt("Ativo"));
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    

}


