/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.User;
import SYS.JDBC.ConexaoBanco;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author gabri
 */
public class UserDAO {
    private Connection conn;
    
    public UserDAO(){
        this.conn = new ConexaoBanco().pegarConexao();
    }
    public void Salvar(User obj){
        try {
            String sql = "insert into usuarios(User,Nome,DataNascimento,CartaoSUS,CPF,RG,Telefone,Municipio,Rua,CEP,Senha,Estado,NivelAcesso,Funcao)"
                    + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getUser());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getDataNascimento());
            stmt.setString(4, obj.getCartaoSus());
            stmt.setString(5, obj.getCPF());
            stmt.setString(6, obj.getRG());
            stmt.setString(7, obj.getTelefone());
            stmt.setString(8, obj.getMunicipio());
            stmt.setString(9, obj.getEndereco());
            stmt.setString(10, obj.getCEP());
            stmt.setString(11, obj.getSenha());
            stmt.setString(12, obj.getEstado());
            stmt.setString(13, obj.getNivelAcesso());
            stmt.setString(14, obj.getFuncao());
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro de cadastro de Usuario"+e);
        }
    }
    public void Editar(User obj){
        try {
            String sql = "update usuarios set User=?,Nome=?,DataNascimento=?,CartaoSUS=?,CPF=?,RG=?,Telefone=?,Municipio=?,"
                    + "Rua=?,CEP=?,Senha=?,Estado=?,NivelAcesso=?,Funcao=? where ID=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getUser());
            stmt.setString(2, obj.getNome());
            stmt.setString(3, obj.getDataNascimento());
            stmt.setString(4, obj.getCartaoSus());
            stmt.setString(5, obj.getCPF());
            stmt.setString(6, obj.getRG());
            stmt.setString(7, obj.getTelefone());
            stmt.setString(8, obj.getMunicipio());
            stmt.setString(9, obj.getEndereco());
            stmt.setString(10, obj.getCEP());
            stmt.setString(11, obj.getSenha());
            stmt.setString(12, obj.getEstado());
            stmt.setString(13, obj.getNivelAcesso());
            stmt.setString(14, obj.getFuncao());
            stmt.setInt(15, obj.getID());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuario Editado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "erro ao Editar o Usuario"+e);
        }
    }
    public void Excluir(User obj){
        try {
            String sql = "delete from usuarios where id=?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getID());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Usuario Excluido com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir o Usuario"+e);
        }
    }
    public User BuscarUser(String user){
        try {
            String aql = "Select * from usuarios where User =?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(aql);
            stmt.setString(1,user);
            ResultSet rs = stmt.executeQuery();
            User obj = new User();
            if(rs.next()){
                obj.setID(rs.getInt("id"));
                obj.setUser(rs.getString("User"));
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSus(rs.getString("CartaoSUS"));
                obj.setCPF(rs.getString("CPF"));
                obj.setRG(rs.getString("RG"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setMunicipio(rs.getString("Municipio"));
                obj.setEndereco(rs.getString("Rua"));
                obj.setCEP(rs.getString("CEP"));
                obj.setSenha(rs.getString("Senha"));
                obj.setEstado(rs.getString("Estado"));
                obj.setNivelAcesso(rs.getString("NivelAcesso"));
                obj.setFuncao(rs.getString("Funcao"));
                
            }
            return obj;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"erro ao Buscar Cliente  "+ e);
        }
        return null;
    }
    public List<User>listar(){
        List<User> lista = new ArrayList<>();
        try {
            String sql = "Select * from usuarios";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                User obj = new User();
                obj.setID(rs.getInt("id"));
                obj.setUser(rs.getString("User"));
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSus(rs.getString("CartaoSUS"));
                obj.setCPF(rs.getString("CPF"));
                obj.setRG(rs.getString("RG"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setMunicipio(rs.getString("Municipio"));
                obj.setEndereco(rs.getString("Rua"));
                obj.setCEP(rs.getString("CEP"));
                obj.setSenha(rs.getString("Senha"));
                obj.setEstado(rs.getString("Estado"));
                obj.setNivelAcesso(rs.getString("NivelAcesso"));
                obj.setFuncao(rs.getString("Funcao"));
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    }
    public List<User>Filtrar(String user){
        List<User> lista = new ArrayList<>();
        try {
            String sql = "Select * from usuarios where User like ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                User obj = new User();
                obj.setID(rs.getInt("id"));
                obj.setUser(rs.getString("User"));
                obj.setNome(rs.getString("Nome"));
                obj.setDataNascimento(rs.getString("DataNascimento"));
                obj.setCartaoSus(rs.getString("CartaoSUS"));
                obj.setCPF(rs.getString("CPF"));
                obj.setRG(rs.getString("RG"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setMunicipio(rs.getString("Municipio"));
                obj.setEndereco(rs.getString("Rua"));
                obj.setCEP(rs.getString("CEP"));
                obj.setSenha(rs.getString("Senha"));
                obj.setEstado(rs.getString("Estado"));
                obj.setNivelAcesso(rs.getString("NivelAcesso"));
                obj.setFuncao(rs.getString("Funcao"));
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a lista"+e);
        }
        return null;
    } 
    
}
