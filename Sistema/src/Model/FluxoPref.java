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
public class FluxoPref {
    private int ID;
    private int Prontuario;
    private LocalDateTime Date;
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProntuario() {
        return Prontuario;
    }

    public void setProntuario(int Prontuario) {
        this.Prontuario = Prontuario;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime Date) {
        this.Date = Date;
    }
    
}
