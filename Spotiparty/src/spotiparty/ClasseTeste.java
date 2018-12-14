/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpotiParty;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author a40284
 */
public class ClasseTeste {
    
    public static boolean is_in_list(String nome, ArrayList<UserNormal> lista){

        for(UserNormal u: lista) {
                if(u.getNome().equals(nome)) {
                    return true;
                }
            }
        return false;
    }
    
    public static int menu_sala(String s) {
        
        String msg = JOptionPane.showInputDialog(null,"Chat:                                  Musica Atual :           \n "+
                 s 
                 + "                                                                                        0 - Exit \n"
                 + "                                                                                        1 - Adicionar user á sala \n "
                 + "                                                                                        2 - Ver os users nesta sala \n "
                 + "                                                                                        3 - Remover um user nesta sala \n "
                 + "                                                                                        4 - Mudar Musica \n");
        
        int escolha = Integer.parseInt(msg);
        
        return escolha;
    }
    
    public static void criar_sala2(Sala sala, ArrayList<String> m, ArrayList<UserNormal> Membros, ArrayList<Musica> musicas, ArrayList<UserNormal> users) {
        String s = "";
        String msg;
        int j;
        
        for(int i=0; i<m.size(); i++) {
            if(i==0) {
                s += m.get(i)+"\t\t"+musicas.get(0).getTitulo()+"\t\t\n";
            }
            else {
                s += m.get(i)+"\t\t\n";
            }
        }//fim do ciclo externo
        
        msg = JOptionPane.showInputDialog(null,"Chat:                                  Musica Atual :           \n "+
                 s 
                 + "                                                                                        0 - Exit \n"
                 + "                                                                                        1 - Adicionar user á sala \n "
                 + "                                                                                        2 - Ver os users nesta sala \n "
                 + "                                                                                        3 - Remover um user nesta sala \n "
                 + "                                                                                        4 - Mudar Musica \n");
    }
     public static void criar_sala(Sala sala, ArrayList<String> m, ArrayList<UserNormal> Membros, ArrayList<Musica> musicas, ArrayList<UserNormal> users){
        String s="";
        String msg=" ";
        int mc =0;
        int j;
       
       

        for(int i =0 ; i< m.size();i++){
            
            if(i == 0){
            s =  s + m.get(i)   + "                  "+ musicas.get(0).getTitulo() + "                 \n ";
            }
            
            else{
            s =  s + m.get(i)   + "                                   \n ";
            }
        }
        
        int ms1 = menu_sala(s);
         
        try{
            
             //menu sala 1
            
            switch(ms1) {
                
                case 0:                     //sair do sistema
                    System.exit(0);
                    break;
                    
                case 1:                     //adicionar um user do vetor de users registados que nao esta no vetor de membros
                
                    String u= JOptionPane.showInputDialog(null,"Que user pretende adicionar á sala ? \n");
                    if(is_in_list(u,users)){
                        for(int i = 0;i < users.size();i++){
                            if(u.equals(users.get(i).getNome())){
                            UserNormal userr = users.get(i).clone();
                            Membros.add(userr);
                            JOptionPane.showMessageDialog(null,"User adicionado com sucesso");
                            criar_sala(sala,m,Membros,musicas,users);
                            }
                        }
                    }

                    break;
                    
                case 2:             //listar o vetor membros da sala
                    
                    String name_ =" ";
                    
                    for( int i = 0; i < Membros.size();i++){
                        name_ = name_ + Membros.get(i).getNome();        
                    }
                    
                    break;
                    
                case 3:             //remover um user do vetor de users registados que esteja no vetor de membros
                    
                    String u2 = JOptionPane.showInputDialog(null,"Que user pretende remover á sala ? \n");
                    if(is_in_list(u2,Membros)){
                        for(int i = 0;i < users.size();i++){
                            if(u2.equals(users.get(i).getNome())){
                            UserNormal userr = users.get(i).clone();
                            Membros.remove(userr);
                            JOptionPane.showMessageDialog(null,"User removido com sucesso");
                            criar_sala(sala,m,Membros,musicas,users);
                            }
                        }
                    }
                    
                    break;
                    
                case 4:             //tocar uma musica cujo titulo esteja nos registos de musica
                    
                    String music = JOptionPane.showInputDialog(null,"Que musica quer ouvir ? ");
                    musicas.get(0).setTitulo(music);
                    criar_sala(sala,m,Membros,musicas,users);
                    
                    break;
            }
        }
        catch(HeadlessException e){
            if(m.size() == 10){
                JOptionPane.showMessageDialog(null,"Numero máximo de mensagens ! A limpar o chat....");
                m = new ArrayList<>();
                criar_sala(sala,m,Membros,musicas,users);
            }
            
            m.add(msg);
            criar_sala(sala,m,Membros,musicas,users); 
            
        }
    }

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
        
        
        int an = -2;
       
        do {

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
           int n_sala = 0;

           JOptionPane.showMessageDialog(null, "Registo feito com sucesso!");
          
           int an1 = -2;
           
           do {
               
                int mLI1 = menu_loggedIn(current_user, guest);           //menu Logged In

                switch (mLI1) {
                    
                    case 1:         //caso para entrar numa sala já existente
                        
                        String s = JOptionPane.showInputDialog(null,"Qual o ID da sala que pretende entrar ? ");
                        n_sala = Integer.parseInt(s);
                        //Verificar se a sala existe
                        
                        break;
                        
                    case 2:         //caso para criar uma sala nova
                        
                        String nome_sala = JOptionPane.showInputDialog(null,"Criar a sua sala : \n"+"Digite o numero da sala\n");
                        int ms = Integer.parseInt(nome_sala);
                        JOptionPane.showMessageDialog(null,"Sala criada com sucesso !");
                        Sala nova_sala = new Sala(ms, current_user);
                        
                        criar_sala(nova_sala, nova_sala.getMensagens(), nova_sala.getMembros(), nova_sala.getMusicas(), users);
                        
                        break;
                        
                    case 3:         //caso para ver friendslist
                        JOptionPane.showMessageDialog( null,"Your friends : \n"
                        + current_user.listar_amigos());
                        break;
                        
                    case 4:         //caso para listar musicas
                        
                        break;
                        
                    case 5:         //caso para sair da aplicação
                        
                        an1 = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair outra vez ? ");
                        if(an1 < 0){
                            System.exit(0);
                        }
                        
                        break;
                        
                 }
                
            }while(an1 > 0);
                 
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
                
                an = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
                if(an < 0){
                      System.exit(0);
                }
                
                break;
        }
        
        
        }while(an > 0);     // repeticao do menu principal enquanto nao der exit
        
        
    }//fim do main
}//fim da classe 

