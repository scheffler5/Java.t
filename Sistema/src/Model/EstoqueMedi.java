/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author gabri
 */
public class EstoqueMedi {
    private int ID;
    private int Medicamentos;
    private int CDC;
    private LocalDateTime Data ;
    private int Fornecedor;
    private Float Quantidade;

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

    public int getCDC() {
        return CDC;
    }

    public void setCDC(int CDC) {
        this.CDC = CDC;
    }

    public LocalDateTime getData() {
        return Data;
    }

    public void setData(LocalDateTime Data) {
        this.Data = Data;
    }

    public int getFornecedor() {
        return Fornecedor;
    }

    public void setFornecedor(int Fornecedor) {
        this.Fornecedor = Fornecedor;
    }

    public Float getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(Float Quantidade) {
        this.Quantidade = Quantidade;
    }
}
