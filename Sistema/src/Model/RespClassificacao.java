/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class RespClassificacao {
    private int ID;
    private String Pressao;
    private int Prontuario_ID;
    private String Batimentos;
    private String Glicose;
    private String temperatura;
    private String Sintomas;

    public String getSintomas() {
        return Sintomas;
    }

    public void setSintomas(String Sintomas) {
        this.Sintomas = Sintomas;
    }
    private String Altura;
    private String Peso;
    private String IMC;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPressao() {
        return Pressao;
    }

    public void setPressao(String Pressao) {
        this.Pressao = Pressao;
    }

    public int getProntuario_ID() {
        return Prontuario_ID;
    }

    public void setProntuario_ID(int Prontuario_ID) {
        this.Prontuario_ID = Prontuario_ID;
    }

    public String getBatimentos() {
        return Batimentos;
    }

    public void setBatimentos(String Batimentos) {
        this.Batimentos = Batimentos;
    }

    public String getGlicose() {
        return Glicose;
    }

    public void setGlicose(String Glicose) {
        this.Glicose = Glicose;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getAltura() {
        return Altura;
    }

    public void setAltura(String Altura) {
        this.Altura = Altura;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }

    public String getIMC() {
        return IMC;
    }

    public void setIMC(String IMC) {
        this.IMC = IMC;
    }
    
    
}
