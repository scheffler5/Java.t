/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class Profi {
    private  int IDProf;
    private String Nome;
    private String CartaoSUS;
    private String IDCredencial;
    private String IDespecialidade;
    private String DataNascimento;
    private String CPF;
    private Float Salario;
    private int Situacao;

    public int getSituacao() {
        return Situacao;
    }

    public void setSituacao(int Situacao) {
        this.Situacao = Situacao;
    }

    public Float getSalario() {
        return Salario;
    }

    public void setSalario(Float Salario) {
        this.Salario = Salario;
    }

    public int getIDProf() {
        return IDProf;
    }

    public void setIDProf(int IDProf) {
        this.IDProf = IDProf;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCartaoSUS() {
        return CartaoSUS;
    }

    public void setCartaoSUS(String CartaoSUS) {
        this.CartaoSUS = CartaoSUS;
    }

    public String getIDCredencial() {
        return IDCredencial;
    }

    public void setIDCredencial(String IDCredencial) {
        this.IDCredencial = IDCredencial;
    }

    public String getIDespecialidade() {
        return IDespecialidade;
    }

    public void setIDespecialidade(String IDespecialidade) {
        this.IDespecialidade = IDespecialidade;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }
    private String Funcao;
}
