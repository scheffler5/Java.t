/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class EstoqueMedica {
    private int ID;
    private int Medicamentos;
    private int Antibiotico;
    private int CDC;
    private String Data;
    private int Fornecedor;

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public int getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(int Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMedicamentos() {
        return Medicamentos;
    }

    public void setMedicamentos(int Medicamentos) {
        this.Medicamentos = Medicamentos;
    }

    public int getAntibiotico() {
        return Antibiotico;
    }

    public void setAntibiotico(int Antibiotico) {
        this.Antibiotico = Antibiotico;
    }

    public int getCDC() {
        return CDC;
    }

    public void setCDC(int CDC) {
        this.CDC = CDC;
    }
    
}
