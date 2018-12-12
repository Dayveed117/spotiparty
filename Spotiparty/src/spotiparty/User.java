/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpotiParty;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class User {
    

    public String nome;

    public User(User u){
        this.nome = u.getNome();
    }
    
    public User(){
        nome = "";
    }
    
    public User(String n){
        nome = n;       
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String n){
        nome = n;
    }
    
}
