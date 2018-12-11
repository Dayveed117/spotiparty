/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Utilizador
 */
public class Amigos {
    
    ArrayList<UserNormal> amigos = new ArrayList<UserNormal>();
    
    public void addFriend(UserNormal u){
        int found = 0;
        
        for(int i = 0; i < amigos.size();i++){
            if(amigos.get(i) == u){
                found = 1;
            }
        }
        if(found == 0){
            amigos.add(null);
            JOptionPane.showMessageDialog(null,"Amigo adicionado com sucesso! ");
        }
    }
    public void removeAmigo(User u){
        for(int i = 0;i < amigos.size();i++){
            if(amigos.get(i) == u){
                amigos.remove(i);
                break;
            }
        }
    }
    
    public String listaramigos(){
        
        String s = "";
        
        for(int i = 0;i < amigos.size();i++){
            s = s + amigos.get(i).getNome();
        }
        return s;
    }
       
    
   
    
}
