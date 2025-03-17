/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class AnamneseMedica {
    private int ID;
    private int Prontuario_ID;
    private String ProcedimentoClinico;
    private String Encaminhamento;
    private String Diagnostico;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProntuario_ID() {
        return Prontuario_ID;
    }

    public void setProntuario_ID(int Prontuario_ID) {
        this.Prontuario_ID = Prontuario_ID;
    }

    public String getProcedimentoClinico() {
        return ProcedimentoClinico;
    }

    public void setProcedimentoClinico(String ProcedimentoClinico) {
        this.ProcedimentoClinico = ProcedimentoClinico;
    }

    public String getEncaminhamento() {
        return Encaminhamento;
    }

    public void setEncaminhamento(String Encaminhamento) {
        this.Encaminhamento = Encaminhamento;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }
    
}
