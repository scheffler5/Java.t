/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class PrescricaoModel {
    private int ID_prescricao;
    private int CDC_ID;
    private int Prontuario;
    private Pacientes Paciente;
    private Prontuario prontuario;
    public Prontuario getID_prontuario(){
        return prontuario;
    }
    public void setID_prontuario(Prontuario prontuario){
        this.prontuario = prontuario;
    }

    public Pacientes getID_Paciente(){
        return Paciente;
    }
    public void setID_Paciente(Pacientes Paciente){
        this.Paciente = Paciente;
    }

    public int getID_prescricao() {
        return ID_prescricao;
    }

    public void setID_prescricao(int ID_prescricao) {
        this.ID_prescricao = ID_prescricao;
    }

    public int getCDC_ID() {
        return CDC_ID;
    }

    public void setCDC_ID(int CDC_ID) {
        this.CDC_ID = CDC_ID;
    }

    public int getProntuario() {
        return Prontuario;
    }

    public void setProntuario(int Prontuario) {
        this.Prontuario = Prontuario;
    }
}
