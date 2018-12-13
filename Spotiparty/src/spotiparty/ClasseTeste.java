/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotiparty;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author a40284
 */
public class ClasseTeste {
    
    public static int menu_principal() {
            
                String choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty! Log in, sign up, ou entra como um guest! \n" 
               + "1 - Registar \n"
               + "2 - Já tenho uma conta \n"
               + "3 - Entrar como guest  \n"
               + "4 - Sair ");
                
               int escolha = Integer.parseInt(choice);
               while(escolha < 1 || escolha > 4) {
                   
                   choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty! Log in, sign up, ou entra como um guest! \n" 
                   + "1 - Registar \n"
                   + "2 - Já tenho uma conta \n"
                   + "3 - Entrar como guest  \n"
                   + "4 - Sair \nUm número no menu you dumbass");
                   
                    escolha = Integer.parseInt(choice);
                    
               }
               return escolha;
    }
    
    
    public static int menu_loggedIn(User current_user) {
        
        String choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty \n" +  current_user.getNome()  + " \n "
               + "1 - Entrar numa sala \n"
               + "2 - Criar sala \n"
               + "3 - Ver amigos \n"
               + "4 - Exit ");
        
               int escolha = Integer.parseInt(choice);
               
               while(escolha < 1 || escolha > 4) {
                   
               choice = JOptionPane.showInputDialog(null, "Welcome to SpotiParty!\n" + current_user.getNome() + "\n" 
               + "1 - Entrar numa sala \n"
               + "2 - Criar sala \n"
               + "3 - Ver amigos \n"
               + "4 - Exit ");
                   
                    escolha = Integer.parseInt(choice);
                    
               }
               return escolha;
           
    }
    
    public static void main(String[] args) {
        
               //Arrays 
       ArrayList<SpotiParty.UserNormal> users = new ArrayList<SpotiParty.UserNormal>(20);
       ArrayList<SpotiParty.Sala> salas = new ArrayList<SpotiParty.Sala>(5);
       ArrayList<SpotiParty.Musica> playlist = new ArrayList<SpotiParty.Musica>();
       int j ; // Controla as musicas


       //Variaveis unicas
       SpotiParty.UserNormal current_user = new SpotiParty.UserNormal(); // Variavel para guardar o current user 
       boolean guest = false ;
       int n_sala;
        
        
        int num;
        num = menu_principal();
        boolean exit = false;

        switch (num) {
            
            case 1:     //caso para fazer registo
                
           String nome = JOptionPane.showInputDialog(null,"Insira o seu nome \n ");
           String nick = JOptionPane.showInputDialog(null,"Insira o seu nickname \n ");
           String numb = JOptionPane.showInputDialog(null,"Insira a sua idade \n ");
           int idade = Integer.parseInt(numb);
           String password = JOptionPane.showInputDialog(null,"Insira a sua password \n");
           
           
           SpotiParty.UserNormal novo = new SpotiParty.UserNormal(nome, nick, password, idade);
           users.add(novo);
           current_user = novo.clone();

           
           JOptionPane.showMessageDialog(null, "Registo feito com sucesso!");
                
                break;
                
            case 2:
                
                break;
                
            case 3:
                
                break;
                
            case 4:
                
                int an = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
                System.out.println(an);
                if(an == 0){
                      //System.exit(0);
                      exit = true;
                }
                
                break;
        }
    }
}

