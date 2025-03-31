/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class Prescricao {
    private int ID;
    private Integer Medicamentos;
    private Integer Antibioticos;
    private int Prescricao;
    private int Frequencia;
    private String medi;
    private String anti;

    public String getMedi() {
        return medi;
    }

    public void setMedi(String medi) {
        this.medi = medi;
    }

    public String getAnti() {
        return anti;
    }

    public void setAnti(String anti) {
        this.anti = anti;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(Integer Medicamentos) {
        this.Medicamentos = Medicamentos;
    }

    public Integer getAntibioticos() {
        return Antibioticos;
    }

    public void setAntibioticos(Integer Antibioticos) {
        this.Antibioticos = Antibioticos;
    }

    public int getPrescricao() {
        return Prescricao;
    }

    public void setPrescricao(int Prescricao) {
        this.Prescricao = Prescricao;
    }

    public int getFrequencia() {
        return Frequencia;
    }

    public void setFrequencia(int Frequencia) {
        this.Frequencia = Frequencia;
    }
    

    
}
