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
 * @author a40284
 */
public class ClasseTeste {
    
        public static void adicionar_user_sala(Sala sala, UserNormal user) {            // antes de chamar a função ver se o current user é admin
        sala.adicionar_user(user);
    }                       
            
    public static void remover_user_sala(Sala sala, UserNormal user) {      //  antes de chamar a função ver se o current user é admin
        sala.remover_user(user);
    }
    
    public static void promover_user_sala(Sala sala, UserNormal user) {
        sala.promover(user);
    }
    
    public static String print_mensagens_sala(Sala sala) {                //print das ultimas 5 mensagens?
        String ss = "";
        int cont=0;
        
        for(String s: sala.getMensagens()) {
            cont++;
            if(cont >= sala.getMensagens().size()-5) {
               ss += s+"\n";
            }
        }
        return ss;
    }

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
    
    
    public static int menu_loggedIn(User current_user, boolean guest) {            //nao sei se isto aqui está mal se é na main

        if(guest == false) {

        String choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty!\n"
               + "1 - Entrar numa sala \n"
               + "2 - Criar sala \n"
               + "3 - Ver amigos \n"
               + "4 - Ver musicas \n"
               + "5 - Exit ");
        
               int escolha = Integer.parseInt(choice);
               while(escolha < 1 || escolha > 5) {
                   
               choice = JOptionPane.showInputDialog(null, "Welcome to SpotiParty!\n"
               + "1 - Entrar numa sala \n"
               + "2 - Criar sala \n"
               + "3 - Ver amigos \n"
               + "4 - Ver musicas \n"
               + "5 - Exit\nWhy are you dumb");
                   
               escolha = Integer.parseInt(choice);
                    
               }
               return escolha;
        }
        
        else {
        
        String choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty " + " guest \n "
               + "1 - Entrar numa sala \n"
               + "2 - Exit ");
        
               int escolha = Integer.parseInt(choice);
               
               while(escolha < 1 || escolha > 2) {
                   
                   choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty " + " guest \n "
               + "1 - Entrar numa sala \n"
               + "2 - Exit\nPick a number you dumbass guest");
                   
                   escolha = Integer.parseInt(choice);
                   
               }
               return escolha;
        }
    }
    
    public static void main(String[] args) {

        ArrayList<UserNormal> users = new ArrayList<>(20);
        ArrayList<Sala> salas = new ArrayList<>(5);
        ArrayList<Musica> playlist = new ArrayList<>();
        UserNormal current_user = new UserNormal();
        int j ; // usada para circular musicas
        boolean guest = false;

        int mp; // menu principal
        mp = menu_principal();
        

        switch (mp) {
            
            case 1:         //caso para fazer registo
                
           String nome = JOptionPane.showInputDialog(null,"Insira o seu nome \n ");
           String nick = JOptionPane.showInputDialog(null,"Insira o seu nickname \n ");
           String num = JOptionPane.showInputDialog(null,"Insira a sua idade \n ");
           int idade = Integer.parseInt(num);
           String password = JOptionPane.showInputDialog(null,"Insira a sua password \n");
           
           UserNormal novo = new UserNormal(nome, nick, password, idade);
           users.add(novo);
           current_user = novo.clone();

           JOptionPane.showMessageDialog(null, "Registo feito com sucesso!");
           
                int mLI1 = menu_loggedIn(current_user, guest);           //menu Logged In
                
                switch (mLI1) {
                    
                    case 1:         //caso para entrar numa sala já existente
                        
                        break;
                        
                    case 2:         //caso para criar uma sala nova
                        
                        break;
                        
                    case 3:         //caso para ver friendslist
                        
                        break;
                        
                    case 4:         //caso para listar musicas
                        
                        break;
                        
                    case 5:         //caso para sair da aplicação
                        
                        break;
                }
                 
                break;
                
            case 2:         //caso para fazer log in
                
                if(users.isEmpty() == false) {
                
                    boolean verificacao = false;
                
                    do {
                    
                     String nickname = JOptionPane.showInputDialog(null,"Insira o seu nickname ");
                     String pass = JOptionPane.showInputDialog(null,"Insira a password ");      // TODO -> meter a pssword com asteriscos 
                     
                     for(UserNormal user: users) {
                         if(user.getNick().equals(nickname) && user.getPW().equals(pass)) {
                             verificacao = true;
                             current_user = new UserNormal(user);
                             break;
                         }
                         else {
                             JOptionPane.showMessageDialog(null,"Dados incorretos , tente outra vez.");
                         }      
                     }
                     }while(verificacao == false);
                    
                    int mLI2 = menu_loggedIn(current_user, guest);
                    
                    switch (mLI2) {
                    
                          case 1:         //caso para entrar numa sala já existente
                        
                              break;
                        
                          case 2:         //caso para criar uma sala nova
                        
                              break;
                        
                          case 3:         //caso para ver friendslist
                        
                              break;
                        
                          case 4:         //caso para listar musicas
                        
                              break;
                        
                           case 5:         //caso para sair da aplicação
                        
                              break;
                        
                     }
                }
                     JOptionPane.showMessageDialog(null,"Nenhum utilizador registado.");
                     
                break;
                
            case 3:         //caso para entrar como guest
                
                break;
                
            case 4:         //caso para sair da aplicação
                
                int an = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
                System.out.println(an);
                if(an == 0){
                      System.exit(0);
                }
                
                break;
        }
    }
}

