/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

public class Dados {
    public boolean ValidarUsuario(String usuarios, String senha){
        if(usuarios.equals("gabriel") && senha.equals("123")){
            return true;
        }else{
            return false;
        }
    
    }
}
