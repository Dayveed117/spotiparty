/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author Utilizador
 */
public class UserNormal extends User{
    
    private int Idade;
    private String Nickname;
    private String Password;
   
    public UserNormal(String n, String nick, String PW, int num) {
        super(n);
        Nickname = nick;
        Password = PW;
        Idade = num;
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
    
    public String toString(){
        return ("Nome: " + nome + "\n Nickname: " + Nickname + "\n Idade: " + Idade);
    }
}
