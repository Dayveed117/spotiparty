/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpotiParty;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author a40284
 */
public class Teste2 {

    public static void save(ArrayList<UserNormal> users) throws FileNotFoundException, IOException{
        
        try{
            
            String basePath = new File("users.dat").getAbsolutePath();
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(basePath));
            
            os.writeObject(users);
            os.flush();
            os.close();
        }
        
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public static ArrayList<UserNormal> loadusers() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        String basePath = new File("users.dat").getAbsolutePath();
        ObjectInputStream fi = new ObjectInputStream(new FileInputStream(basePath));
        
        ArrayList <UserNormal> users = (ArrayList) fi.readObject();
        fi.close();
        return users;
        
    }
    
    
    public static void save_musicas(ArrayList<Musica> musicas) throws FileNotFoundException, IOException{
        
        try{
            String basePath = new File("musicas.dat").getAbsolutePath();
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(basePath));
            
            os.writeObject(musicas);
            os.flush();
            os.close();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
     
     public static ArrayList<Musica> loadmusicas() throws FileNotFoundException, IOException, ClassNotFoundException{
        
         String basePath = new File("musicas.dat").getAbsolutePath();
         ObjectInputStream fi = new ObjectInputStream(new FileInputStream(basePath));
         
         ArrayList <Musica> musicas = (ArrayList) fi.readObject();
         fi.close();
         return musicas;
     }
     
     public static boolean is_in_list(String nome, ArrayList<UserNormal> lista){

         boolean encontrou = false;
         for(int i = 0;i < lista.size() ; i++){
             if(nome.equals(lista.get(i).getNick())){
                 encontrou = true;
                 break;
             }
         }
         return encontrou;
     }//fim do is_in_list
    
    
     public static void criar_sala(Sala sala , ArrayList<String> m, ArrayList<UserNormal> Membros, ArrayList<Musica> musicas, ArrayList<UserNormal> users, ArrayList<String> musicas_sugeridas) {
         
         String s="";
         String msg="";
         int opt;

         for(int i =0 ; i< m.size();i++){
             
             if(i == 0){
                 s =  s + m.get(i)   + "                  "+ musicas.get(0).getTitulo() + "                 \n ";
             }
             
             else{
                 s =  s + m.get(i)   + "                                   \n ";}
         }
         
         
         for(int c = 0;c < 3;c++){
             s = s + "\n";
         }
         for(int k = 0;k < musicas_sugeridas.size();k++){
             s = s + musicas_sugeridas.get(k) +" \n";
             
         }
         
         msg = JOptionPane.showInputDialog(null,"Chat:                                  Musica Atual :           \n"+
                 s
                 + "                                                                                        0 - Exit \n"
                 + "                                                                                        1 - Adicionar user á sala \n"
                 + "                                                                                        2 - Ver os users nesta sala \n"
                 + "                                                                                        3 - Mudar Musica \n");
         
         try{
             
             opt = Integer.parseInt(msg);
             switch (opt) {
                 
                 case 0:                    //para sair do programa
                     
                     save(users);
                     System.exit(0);
                     
                     break;
                     
                 case 1:                       //Adicionar membro à sala
                     
                     String u = JOptionPane.showInputDialog(null,"Que user pretende adicionar à sala ? \n");

                     if(!is_in_list(u,Membros) && is_in_list(u,users)) {
                         for(int i = 0;i < users.size();i++) {
                             if(u.equals(users.get(i).getNick())) {
                                 UserNormal userr = users.get(i).clone();
                                 Membros.add(userr);
                                 save(users);
                                 JOptionPane.showMessageDialog(null,"User adicionado com sucesso");
                                 criar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
                             }
                         }
                     }
                     if(is_in_list(u,Membros)) {
                         JOptionPane.showMessageDialog(null,"User já está na sala!");
                     }
                     else{
                         JOptionPane.showMessageDialog(null,"User não existe...");
                         criar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
                     }
                     
                     break;
                     
                 case 2:                //ver lista de membros na sala
                     
                     String name_ ="";
                     for(int i = 0; i < Membros.size();i++){
                         name_ += Membros.get(i).getNick()+"\n";
                     }
                     
                     JOptionPane.showMessageDialog(null,"Users nesta sala:\n\n"+name_+"\n");
                     criar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
                     
                     break;
                     
                 case 3:                //mudar a musica atual
                     
                     String music = JOptionPane.showInputDialog(null,"Que musica quer ouvir ? ");
                     musicas.get(0).setTitulo(music);
                     criar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
                     
                     break;
                     
             }
         }//fim do try
         catch(Exception e){
             if(m.size() == 10){
                 JOptionPane.showMessageDialog(null,"Numero máximo de mensagens ! A limpar o chat....");
                 m = new ArrayList<>(10);
                 m.add("Escreva algo");
             }
             else{
                 m.add(msg);
             }
             criar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
         }
     }//fim do criar sala
    
    
    public static void entrar_sala(Sala sala , ArrayList<String> m,ArrayList<UserNormal> Membros,ArrayList<Musica> musicas,ArrayList<UserNormal> users,ArrayList<String> musicas_sugeridas){
        
        String s="";
        String msg="";
        int mc =0;
        int opt;
        
        for(int i =0 ; i< m.size();i++){
            
            if(i == 0){
                s =  s + m.get(i)   + "                  "+ musicas.get(i).getTitulo() + "                 \n ";
            }
            
            else{
                s =  s + m.get(i)   + "                                   \n ";}
        }
        
        for(int c = 0;c < 3;c++){
            s = s + "\n";
        }
        
        for(int k = 0;k < musicas_sugeridas.size();k++){
            s = s + musicas_sugeridas.get(k) +" \n";
            
        }
        
        msg = JOptionPane.showInputDialog(null,"Chat:                                  Musica Atual :           \n"+s
                + "                                                                                        0 - Exit \n"
                + "                                                                                        1 - Ver os users nesta sala \n"
                + "                                                                                        2 - Sugerir musica \n");
        
        
        try{
            
            opt = Integer.parseInt(msg);
            switch (opt) {
                
                case 0:                 //system exit
                    
                    save(users);
                    System.exit(0);
                    
                    break;
                    
                case 1:                 //ver Membros da sala
                    
                    String nick ="";
                    for( int i = 0; i < Membros.size();i++){
                        nick = nick + Membros.get(i).getNick();
                    }
                    JOptionPane.showMessageDialog(null,nick);
                    entrar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
                    
                    break;
                    
                case 2:             //opção para sugerir uma música
                    
                    String music = JOptionPane.showInputDialog(null,"Que musica quer sugeir ? ");
                    musicas_sugeridas.add(music);
                    entrar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
                    
                    break;
            }
        }
        
        catch(Exception e){
            if(m.size() == 10){
                JOptionPane.showMessageDialog(null,"Numero máximo de mensagens ! A limpar o chat....");
                m = new ArrayList<String>();
                entrar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
            }
            m.add(msg);
            entrar_sala(sala,m,Membros,musicas,users,musicas_sugeridas);
        }
    }//fim do entrar sala

    
    public static int menu_principal() {
        
        while(true){
            try{
                String choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty! Log in, sign up, ou entra como um guest! \n\n"
                        + "1 - Sign Up \n"
                        + "2 - Log In \n"
                        + "3 - Entrar como guest \n"
                        + "4 - Adicionar Música \n"
                        + "5 - Remover Música \n"
                        + "6 - Listar Users \n"
                        + "7 - Sair \n\n");
                
                int escolha = Integer.parseInt(choice);
                while(escolha < 1 || escolha > 7) {
                    
                    choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty! Log in, sign up, ou entra como um guest! \n\n"
                            + "1 - Sign Up \n"
                            + "2 - Log In \n"
                            + "3 - Entrar como guest \n"
                            + "4 - Adicionar Música \n"
                            + "5 - Remover Música \n"
                            + "6 - Listar Users \n"
                            + "7 - Sair \n\n");
                    
                    escolha = Integer.parseInt(choice);
                    
                }
                return escolha;
            }
            
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Escolha invalida");
            }
        }
    }//fim do menu principal
    
    
    public static int menu_loggedIn(User current_user, boolean guest) {            //nao sei se isto aqui está mal se é na main
        
        while(true) {
            try {
                
                if(guest == false) {                //no caso de entrar como UserNormal
                    
                    String choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty!\n\n"
                            + "1 - Entrar numa sala \n"
                            + "2 - Criar sala \n"
                            + "3 - Adicionar amigo \n"
                            + "4 - Ver amigos \n"
                            + "5 - Ver musicas \n"
                            + "6 - Sair \n\n");
                    
                    int escolha = Integer.parseInt(choice);
                    while(escolha < 1 || escolha > 5) {
                        
                        choice = JOptionPane.showInputDialog(null, "Welcome to SpotiParty!\n\n"
                                + "1 - Entrar numa sala \n"
                                + "2 - Criar sala \n"
                                + "3 - Adicionar amigo \n"
                                + "4 - Ver amigos \n"
                                + "5 - Ver musicas \n"
                                + "6 - Sair\n\n");
                        
                        escolha = Integer.parseInt(choice);
                        
                    }
                    return escolha;
                }//fim do menu do UserNormal

                else {               //entrar na sala como guest
                    
                    int escolha= 0;
                    String choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty" + " Guest!\n\n"
                            + "1 - Entrar numa sala\n"
                            + "2 - Exit\n\n");
                    
                    escolha = Integer.parseInt(choice);
                    while(escolha < 1 || escolha > 2) {
                        
                        choice = JOptionPane.showInputDialog(null,"Welcome to SpotiParty" + " Guest!\n\n"
                                + "1 - Entrar numa sala\n"
                                + "2 - Exit\n\n");
                        
                        escolha = Integer.parseInt(choice);
                    }
                    return escolha;
                }//fim do menu do guest
            }
            catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira uma escolha valida");
            }
        }
    }
    
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        ArrayList<UserNormal> users;
        try{
            users= new ArrayList<>(20);
            users = loadusers();
            
        }
        catch(Exception e){
            users = new ArrayList<>(20);
        }
        
        ArrayList<Musica> playlist ;
        try{
            playlist = new ArrayList<>(20);
            playlist = loadmusicas();
            
        }
        catch(Exception e){
            playlist = new ArrayList<>(20);
        }
        
        ArrayList<Sala> salas = new ArrayList<>(5);
        
        UserNormal current_user = new UserNormal();
        ArrayList<String>suggested = new ArrayList<>();
        suggested.add("Musicas Sugeridas : ");
        
        boolean guest = false;
        int idade, an = -2;
        
        do {

            int mp = menu_principal();      //menu principal

        switch (mp) {
            
            case 1:         //caso para fazer registo de user           MENU PRINCIPAL
                
                String nome = JOptionPane.showInputDialog(null,"Insira o seu nome \n ");
                String nick = JOptionPane.showInputDialog(null,"Insira o seu nickname \n ");
                
                while(true){
                    try{
                        String num = JOptionPane.showInputDialog(null,"Insira a sua idade \n ");
                        idade = Integer.parseInt(num);
                        break;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "A idade tem de ser um numero !!!");
                    }
                }
                String password = JOptionPane.showInputDialog(null,"Insira a sua password \n");
                
                UserNormal novo = new UserNormal(nome, nick, password, idade);
                users.add(novo);
                current_user = novo.clone();
                
                save(users);
                
                JOptionPane.showMessageDialog(null, "Registo feito com sucesso!");
           
           int mLI1 = menu_loggedIn(current_user, guest);           //menu Logged In
           
           switch (mLI1) {
               
               case 1:         //caso para entrar numa sala ;já existente           MENU SECUNDARIO     1
                   
                   Sala current_sala = new Sala(current_user);
                   String n_salaa = JOptionPane.showInputDialog(null,"Número da sala que pretende entrar?");
                   int n_salaaa = Integer.parseInt(n_salaa);
                   try{
                       current_sala = salas.get(n_salaaa);
                   }
                   catch(Exception e){
                       JOptionPane.showMessageDialog(null, "Sala nao existe");
                   }
                   
                   try{
                       current_sala.getMembros().add(current_user);
                       entrar_sala(current_sala, current_sala.getMensagens(), current_sala.getMembros(), current_sala.getMusicas(), users, suggested);
                   }
                   catch(Exception e){
                       JOptionPane.showMessageDialog(null, "Erro ao entrar na sala");
                   }
                   
                   break;
                   
               case 2:                  //Caso para criar uma criar sala            MENU SECUNDARIO         1
                   
                   String nome_sala = JOptionPane.showInputDialog(null,"Criar a sua sala : \n"
                           + "Digite o numero da sala \n");
                   
                   int ms = Integer.parseInt(nome_sala);
                   JOptionPane.showMessageDialog(null,"Sala criada com sucesso !");
                   Sala nova_sala = new Sala(ms,current_user);
                   criar_sala(nova_sala,nova_sala.getMensagens(),nova_sala.getMembros(),nova_sala.getMusicas(),users,suggested);
                   
                   break;
                   
                   
               case 3:              //adicionar Amigos          MENU SECUNDARIO 1
                   
                   String nic = JOptionPane.showInputDialog(null,"Que user pretende adicionar à lista de amigos? \n");
                   if(!is_in_list(nic,current_user.getAmigos()) && is_in_list(nic,users)) {
                       for(int i = 0;i < users.size();i++) {
                           if(nic.equals(users.get(i).getNick())) {
                               UserNormal userr = users.get(i).clone();
                               current_user.addFriend(userr);
                               JOptionPane.showMessageDialog(null,"User adicionado com sucesso");
                           }
                       }
                   }
                   else{
                       if(is_in_list(nic,current_user.getAmigos())) {
                           JOptionPane.showMessageDialog(null,"User já está nos amigos!");
                       }
                       else{
                           JOptionPane.showMessageDialog(null,"User não existe...");
                   }
                   
                   break;
                   
                   }
                   
               case 4:         //caso para ver friendslist                      MENU SECUNDARIO         1
                   
                   JOptionPane.showMessageDialog( null,"Os teus amigos : \n"
                           + current_user.listar_amigos());
                   mLI1 = menu_loggedIn(current_user, guest);
                   
                   break;
                   
               case 5:         //caso para listar musicas               MENU SECUNDARIO         1
                   
                   String s ="";
                   for(int i = 0;i< playlist.size();i++){
                       String title = playlist.get(i).getTitulo();
                       String author = playlist.get(i).getAutor()+"\n";
                       s += title+"      -      "+author;
                   }
                   
                   JOptionPane.showMessageDialog(null, "Lista de músicas:\n\n"+s+"\n");
                   
                    mLI1 = menu_loggedIn(current_user, guest);
                   break;
                   
               case 6:         //caso para sair da aplicação                MENU SECUNDARIO         1
                   
                   int and = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
                   if(and == 0){
                       System.exit(0);
                   }
                   
               break;
               
           }
                
            case 2:      //caso para fazer log in   MENU PRINCIPAL
                
                if(users.isEmpty() == false) {
                    boolean verificacao = false;
                    
                    do {
                        String nickname = JOptionPane.showInputDialog(null,"Insira o seu nickname ");
                        String pass = JOptionPane.showInputDialog(null,"Insira a password ");      
                        
                        for(int i = 0;i < users.size();i++) {
                            if((users.get(i).getNick().equals(nickname)) && (users.get(i).getPW().equals(pass))) {
                                verificacao = true;
                                JOptionPane.showMessageDialog(null, "Login com sucesso");
                                current_user = new UserNormal(users.get(i));
                                break;
                            }
                        }
                        if(verificacao == false){
                            JOptionPane.showMessageDialog(null, "Dados Incorretos");
                        }
                        
                    }while(verificacao == false);
                    
                    int mLI2 = menu_loggedIn(current_user, guest);
                    
                    switch (mLI2) {
                        
                        case 1:         //caso para entrar numa sala já existente       MENU SECUNDARIO         2
                            
                            Sala current_sala = new Sala(current_user);
                            String n_salaa = JOptionPane.showInputDialog(null,"Numero da sala que pretende entrar");
                            int n_salaaa = Integer.parseInt(n_salaa);
                            try{
                                current_sala = salas.get(n_salaaa);
                            }
                            catch(Exception e){
                            }
                            entrar_sala(current_sala,current_sala.getMensagens(),current_sala.getMembros(),current_sala.getMusicas(),users,suggested);
                            break;
                            
                        case 2:         //caso para criar uma sala nova             MENU SECUNDARIO         2
                            String nome_sala = JOptionPane.showInputDialog(null,"Criar a sua sala : \n"
                                    + "Digite o numero da sala \n");
                            
                            int ms = Integer.parseInt(nome_sala);
                            JOptionPane.showMessageDialog(null,"Sala criada com sucesso !");
                            Sala nova_sala = new Sala(ms,current_user);
                            criar_sala(nova_sala,nova_sala.getMensagens(),nova_sala.getMembros(),nova_sala.getMusicas(),users,suggested);
                            break;
                            
                            
                        case 3:             //adicionar amigos              MENU SECUNDARIO 2
                            
                            String nic = JOptionPane.showInputDialog(null,"Que user pretende adicionar à lista de amigos? \n");
                            if(!is_in_list(nic,current_user.getAmigos()) && is_in_list(nic,users)) {
                                for(int i = 0;i < users.size();i++) {
                                    if(nic.equals(users.get(i).getNick())) {
                                        UserNormal userr = users.get(i).clone();
                                        current_user.addFriend(userr);
                                        JOptionPane.showMessageDialog(null,"User adicionado com sucesso!");
                                        break;
                                    }
                                }
                            }
                            else {
                                if(is_in_list(nic,current_user.getAmigos())) {
                                    JOptionPane.showMessageDialog(null,"User já está nos amigos!");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"User não existe...");
                                }
                            }
                            
                            break;
                                   
                        case 4:         //caso para ver friendslist         MENU SECUNDARIO         2
                            JOptionPane.showMessageDialog( null,"Os teus amigos : \n"
                                    + current_user.listar_amigos());
                            break;
                            
                        case 5:         //caso para listar musicas      MENU SECUNDARIO         2
                            
                            String s ="";
                            for(int i = 0;i< playlist.size();i++){
                                String title = playlist.get(i).getTitulo();
                                String author = playlist.get(i).getAutor()+"\n";
                                s += title+"      -      "+author;
                            }
                            
                            JOptionPane.showMessageDialog(null,"Lista de músicas\n\n"+s);
                            
                            break;
                            
                        case 6:         //caso para sair da aplicação       MENU SECUNDARIO         2
                            
                            int and = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
                            
                            if(and == 0){
                                System.exit(0);
                                
                                break;
                                
                            }
                            
                    }//fim do switch do menu2
                    
                }
                else {
                    JOptionPane.showMessageDialog(null, "Não há users registados.\nCrie uma e faça LogIn!");
                }
                
                break;          //break do caso 2
        
            case 3:             //caso para entrar como guest
                
                int mLI2 = menu_loggedIn(current_user, true);
                
                switch(mLI2) {
                    
                    case 1:         //caso para entrar numa sala já existente       MENU SECUNDARIO         3
                        
                        Sala current_sala  = new Sala(new Guest("guest"));
                        String n_salaa = JOptionPane.showInputDialog(null,"Numero da sala que pretende entrar");
                        int n_salaaa = Integer.parseInt(n_salaa);
                        try{
                            current_sala = salas.get(n_salaaa);
                        }
                        catch(Exception e){
                            entrar_sala(current_sala,current_sala.getMensagens(),current_sala.getMembros(),current_sala.getMusicas(),users,suggested);
                        }
                        break;
                        
                    case 2:         //caso para sair da aplicação           MENU SECUNDARIO         3
                        
                        int and = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
                        if(and == 0){
                            System.exit(0);
                            break;
                            
                        }
                }//fim do switch do menu do guest
                
                break;          //break do caso 3
                
            case 4:         //caso para adicionar uma musica ao vetor playlist      MENU PRINCIPAL
                
                String titulo = JOptionPane.showInputDialog(null,"Qual vai ser o título da música?");
                String autor = JOptionPane.showInputDialog(null,"Qual o artista dessa música?");
                String album = JOptionPane.showInputDialog(null,"De que album é essa música?");
                String genero = JOptionPane.showInputDialog(null,"De que género é essa música?");
                
                double dur = 0;
                
                while(true){
                    try{
                        String duracao = JOptionPane.showInputDialog(null,"Que duração vai ter a musica?");
                        dur = Double.parseDouble(duracao);
                        break;
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Insira uma duração valida");
                    }
                }
                
                Musica m = new Musica(dur, titulo, autor, album, genero);
                
                if(playlist.isEmpty() == false) {
                    
                    try{
                        for(Musica musi: playlist) {
                            if(titulo.equals(musi.getTitulo()) && autor.equals(musi.getAutor())) {
                                JOptionPane.showMessageDialog(null, "Musica já registada");
                                break;
                            }
                            else {
                                playlist.add(m);
                                JOptionPane.showMessageDialog(null, "Musica adicionada com sucesso");
                            }
                        }
                    }
                    catch(Exception e) {
                    }
                }
                else {
                    playlist.add(m);
                    JOptionPane.showMessageDialog(null, "Musica adicionada com sucesso");
                }
                save_musicas(playlist);
                
                break;          //break do caso 4
                
            case 5:         //caso para remover uma musica ao vetor playlist        MENU PRINCIPAL
                
                if(playlist.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não há músicas a remover.");
                    break;
                }
                
                String tit = JOptionPane.showInputDialog(null,"Qual vai ser o título da música?");
                String aut = JOptionPane.showInputDialog(null,"Qual o artista dessa música?");
                
                for(Musica mus: playlist) {
                    if(tit.equals(mus.getTitulo()) && aut.equals(mus.getAutor())) {
                        playlist.remove(mus);
                        JOptionPane.showMessageDialog(null, "Musica removida com sucesso.");
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Musica nao encontrada nos registos.");
                        break;
                    }
                }
                save_musicas(playlist);
                break;
                    
            case 6:         //caso para listar todos os users
                
                if(users.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não existem utilizadores.");
                    break;
                }
                String s ="";
                for(int i = 0;i< users.size();i++){
                    String nic = users.get(i).getNick()+"\n";
                    s += nic;
                }
                
                JOptionPane.showMessageDialog(null,"Lista de Users\n\n"+s+"\n");
                
                break;
                
            case 7:         //caso para sair da aplicação               MENU PRINCIPAL
                
                an = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende sair ? ");
                if(an < 0){
                    System.exit(0);
                }
                
                break;
                
        }
        
        }while(an > 0 || an == -2);     // repeticao do menu principal enquanto nao der exit
        
    }//fim do main
}//fim da classe 

