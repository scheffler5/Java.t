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
    private CDC cdc;
    private String paci;
    private int Baixada;

    public String getPaci() {
        return paci;
    }

    public void setPaci(String paci) {
        this.paci = paci;
    }
    private String CDC;
    private int Prontu;

    public Pacientes getPaciente() {
        return Paciente;
    }

    public void setPaciente(Pacientes Paciente) {
        this.Paciente = Paciente;
    }

    public String getCDC() {
        return CDC;
    }

    public void setCDC(String CDC) {
        this.CDC = CDC;
    }

    public int getProntu() {
        return Prontu;
    }

    public void setProntu(int Prontu) {
        this.Prontu = Prontu;
    }

    public CDC getCdc() {
        return cdc;
    }

    public void setCdc(CDC cdc) {
        this.cdc = cdc;
    }
    

    public int getBaixada() {
        return Baixada;
    }

    public void setBaixada(int Baixada) {
        this.Baixada = Baixada;
    }
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
