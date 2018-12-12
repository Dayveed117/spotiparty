/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SpotiParty;
import java.io.*;
import java.util.*;
import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;



public class main{
    
    
    public static void adicionar_user_sala() { 
    //usar isto e verificar se o current user é o admin
        
    }
    
    //Recebe a sala e o user que a criou (ArrayList<String> m , Sala s, ArrayList<String> Membros,String musicaAtual)
    public static void criar_sala(Sala sala , ArrayList<String> m,ArrayList<UserNormal> Membros,ArrayList<Musica> musicas,int j ){
        String s="";

        for(int i =0 ; i< 10;i++){
            
            if(Membros.get(i).getNome() == null){
                System.out.println("Hello");
            }
            
            s =  s + Membros.get(i).getNome()    +  "                             " +  m.get(i)   + "                              "+ musicas.get(j).getTitulo() + "                 \n ";
        }
         
       
        
        JOptionPane.showInputDialog(null,"Membros :                          Chat:                                  Musica Atual :           \n "
                +                        s);
        
        
    }

    
    public static boolean is_in_list(String nome, ArrayList<UserNormal> lista){
        boolean encontrou = false;
        for(int i = 0;i < lista.size() ; i++){
            if(lista.get(i).getNome() == nome){
                encontrou = true;
            }
        }
        
        return encontrou;
    }
    
    
    public static UserNormal get_user(String nome, ArrayList<UserNormal> lista){
        boolean encontrou = false;
        for(int i = 0;i < lista.size() ; i++){
            if(lista.get(i).getNome() == nome){
                return lista.get(i);
            }
        }
        return null;

    }
    
    
    
    public static void main(String[] args) {
        
       //Arrays 
       ArrayList<UserNormal> users = new ArrayList<UserNormal>(20);
       ArrayList<Sala> salas = new ArrayList<Sala>(5);
       ArrayList<Musica> playlist = new ArrayList<Musica>();
       int j ; // Controla as musicas


       //Variaveis unicas
       UserNormal current_user = new UserNormal(); // Variavel para guardar o current user 
       boolean guest = false ;
       String choice2;
       int n_sala , escolheu=0;
        
        
      while(escolheu == 0){
          
           //Escolha do utilizador
               String choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty \n" 
               + "1 - Registar \n"
               + "2 - Já tenho uma conta \n"
               + "3 - Entrar como guest  \n"
               + "4 - Sair ");
       
       
       int escolha = Integer.parseInt(choice);
       if(escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4){
           escolheu = 1;
       }
       
       //Sair da aplicação
       if(escolha == 4){
           int an = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
           if(an == 0){
              System.exit(0);
           }
          
       }
       
       
       // Registar um novo user
       if (escolha == 1 ){
           String nome = JOptionPane.showInputDialog(null,"Insira o seu nome \n ");
           String nick = JOptionPane.showInputDialog(null,"Insira o seu nickname \n ");
           String num = JOptionPane.showInputDialog(null,"Insira a sua idade \n ");
           int idade = Integer.parseInt(num);
           String password = JOptionPane.showInputDialog(null,"Insira a sua password \n");
           
           
           UserNormal novo = new UserNormal(nome,nick,password,idade);
           users.add(novo);
           current_user = novo.clone();

           
           JOptionPane.showMessageDialog(null, "Registo feito com sucesso!");
           
           
           
       }
       
       //Log in
       if(escolha == 2){
           boolean dados_corretos = false;

           while(dados_corretos == false){
             String nickname = JOptionPane.showInputDialog(null,"Insira o seu nickname ");
             String password = JOptionPane.showInputDialog(null,"Insira a password "); // TODO -> meter a pssword com asteriscos 
             
             
             //Verirficar se os dados estão corretos com os users registadors 
              for(int i = 0 ;  i < users.size() ; i++){
                if(nickname == users.get(i).getNick()){ 
                  if(password == users.get(i).getPW()){
                    dados_corretos = true;
                    current_user = users.get(i).clone();
                  }
                  else{
                    break;
                  }
                }
              }

              if(dados_corretos == false ){
                JOptionPane.showMessageDialog(null,"Dados incorretos , tente outra vez.");
              }
             }
          
       }
       
       
       //Entrar como Guest
       if(escolha == 3 ){
            guest = true;
           //Cria um guest
            User current_guest = new User("guest");
            
       }
      }
       
       
       //Verificar se entrou como guest
       if(guest == true){
              choice2 = JOptionPane.showInputDialog(null,"Welcome to SpotiParty " + " guest \n "
               + "1 - Entrar numa sala \n"
               + "4 - Exit ");
              if(Integer.parseInt(choice2) != 1 && Integer.parseInt(choice2) != 4){
                  JOptionPane.showMessageDialog(null, "Escolha Inválida");
              }
       }
       


       //Não é guest
       else{
              choice2 = JOptionPane.showInputDialog(null,"Welcome to SpotiParty \n" +  current_user.getNome()  + " \n "
               + "1 - Entrar numa sala \n"
               + "2 - Criar sala \n"
               + "3 - Ver amigos \n"
               + "4 - Exit ");
           
       }
       


       int escolha_user = Integer.parseInt(choice2);
       

       //Sair
       if(escolha_user == 4 ){
           int an = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
           if(an == 0){
              System.exit(0);
           }
       }


       if(escolha_user == 2 || escolha_user == 1){

                  //Entrar numa sala
               if(escolha_user == 1 ){
                   String s = JOptionPane.showInputDialog(null,"Qual o ID da sala que pretende entrar ? ");
                   n_sala = Integer.parseInt(s);
                   //Verificar se a sala existe
                   
               }

               
               //Criar uma sala
               if(escolha_user == 2 && guest == false){
                   //Criar sala
                  String nome_sala = JOptionPane.showInputDialog(null,"Criar a sua sala : \n"
                    + "Digite o nome da sala \n");
                  JOptionPane.showMessageDialog(null,"Sala criada com sucesso !");
                  Sala nova_sala = new Sala(nome_sala,current_user);
                  criar_sala(nova_sala,nova_sala.getMensagens(),nova_sala.getMembros(),nova_sala.getMusicas(),0);
               }
          }
               



       
       //Ver amigos
       if(escolha_user == 3 && guest == false){

           //Opções
           String amigos_choice = JOptionPane.showInputDialog(null, "1 - Adicionar amigo \n"
                   + "2 - Remover amigo \n "
                   + "3 - Ver lista de amigos \n "
                   + "4 - Sair \n");
           

           int amigos_escolha = Integer.parseInt(amigos_choice);
           
           //Adicionar Amigo
           if(amigos_escolha == 1){
              String a =  JOptionPane.showInputDialog(null,"Que amigo pretende adicionar ? ");
               if(is_in_list(a,users)){
                   current_user.addFriend(get_user(a,users));
                       JOptionPane.showMessageDialog(null,"Amigo adicionado com sucesso ");
                   }
               }
              
                
           
           

           //Remover Amigo
           if(amigos_escolha == 2){
            String a =  JOptionPane.showInputDialog(null,"Que amigo pretende adicionar ? ");
               if(is_in_list(a,users)){
                   current_user.removeAmigo(get_user(a,users));
                       JOptionPane.showMessageDialog(null,"Amigo removido com sucesso ");
                   }
               
           }
           

           //Listar os amigos
           if(amigos_escolha == 3){
            JOptionPane.showMessageDialog( null,"Your friends : \n"
              + current_user.listar_amigos());
             }
            }
          
     }
 }
