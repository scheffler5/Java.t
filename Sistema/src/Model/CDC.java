/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gabri
 */
public class CDC {
    private int ID;
    private String CDC;
    private Prontuario pront;

    public Prontuario getPront() {
        return pront;
    }

    public void setPront(Prontuario pront) {
        this.pront = pront;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCDC() {
        return CDC;
    }

    public void setCDC(String CDC) {
        this.CDC = CDC;
    }
}
