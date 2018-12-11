/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpotiParty;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Utilizador
 */
public class UserNormal extends User{
    
    private int Idade;
    private String Nickname;
    private String Password;
    private ArrayList<UserNormal> amigos = new ArrayList<UserNormal>();
   
    public UserNormal(String n, String nick, String PW, int num) {
        super(n);
        Nickname = nick;
        Password = PW;
        Idade = num;
    }
    
    public UserNormal(UserNormal u){
        this.Idade = u.getIdade();
        this.Nickname = u.getNick();
        this.Password = u.getPW();
        this.amigos = u.getAmigos();
    }
    
    
    public String getNick(){
        return Nickname;
    }
    public String getPW(){
        return Password;
    }
    public int getIdade(){
        return Idade;
    }
    
    public void setNick(String nick){
        Nickname = nick;
    }
    public void setPW(String PW){
        Password = PW;
    }

    public UserNormal clone(){
        UserNormal c = new UserNormal(super.getNome(),this.Nickname,this.Password,this.Idade);
        return c;
    }
    
    
    public void addFriend(UserNormal u){
        int found = 0;
        
        for(int i = 0; i < amigos.size();i++){
            if(u == amigos.get(i)){
                found = 1;
            }
        }
        if(found == 0){
            amigos.add(u);
            JOptionPane.showMessageDialog(null,"Amigo adicionado com sucesso! ");
        }
    }
    
    
        public void removeAmigo(UserNormal u){
        for(int i = 0;i < amigos.size();i++){
            if(amigos.get(i) == u){
                amigos.remove(u);
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
       
      
    public ArrayList<UserNormal> getAmigos(){
        return amigos;
        
    }
    
         
    
    public String toString(){
        return ("Nome: " + nome + "\n Nickname: " + Nickname + "\n Idade: " + Idade);
    }
}
