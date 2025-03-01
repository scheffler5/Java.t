/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitarios;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author gabri
 */
public class Utilitarios {
    public void LimpaTela(JPanel container){
        Component conponents[] = container.getComponents();
        for(Component component : conponents){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
}
