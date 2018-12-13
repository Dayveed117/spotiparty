/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpotiParty;
import java.util.ArrayList;
import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;
/**
 *
 * @author a40284
 */
public class Sala {
    
    private int NumeroDaSala;
    private ArrayList<UserNormal> Membros  = new ArrayList<UserNormal>();
    private AdminUser admin;
    private ArrayList<Musica> Musicas = new ArrayList<Musica>();
    private ArrayList<String> Mensagens = new ArrayList<String>();
    
    
    
    public Sala(int NumeroDaSala, UserNormal user ) {
        this.NumeroDaSala = NumeroDaSala;
        this.admin = new AdminUser(user,true);
        this.Membros.add(user);
        this.Mensagens.add("Escreva algo");
        this.Musicas.add(new Musica());
    }
    
    
    
    public ArrayList<Musica> getMusicas() {
        return Musicas;
    }
    

    public void setMusicas(ArrayList<Musica> Musicas) {
        this.Musicas = Musicas;
    }

    public ArrayList<String> getMensagens() {
        return Mensagens;
    }

    public void setMensagens(ArrayList<String> Mensagens) {
        this.Mensagens = Mensagens;
    }
    
    public int getNomeDaSala() {
        return NumeroDaSala;
    }

    public void setNomeDaSala(int NumeroDaSala) {
        this.NumeroDaSala = NumeroDaSala;
    }

    public ArrayList<UserNormal> getMembros() {
        return Membros;
    }

    public void setMembross(ArrayList<UserNormal> Membros) {
        this.Membros = Membros;
    }

    public AdminUser getAdmin() {
        return admin;
    }

    public void setAdmin(UserNormal admin) {      //na main apenas o admin poder promover outro admin
        this.admin = new AdminUser(admin,true);
    }
    
    //para remover uma sala basta por a sala toda a null e fazer print de sucesso??
    
    //checkar na main se o current_user é admin para fazer estas operações
    public void adicionar_user(Sala sala, UserNormal user) {
        if(Membros.contains(user)) {
            JOptionPane.showMessageDialog(null, "Utilizador já está na sala");
        }
        else {
            Membros.add(user);
            JOptionPane.showMessageDialog(null, user.getNome()+" juntou-se à sala "+NumeroDaSala);
        }
    }
    
    public void remover_user(Sala sala, User user) {
        if(Membros.contains(user)) {
            Membros.remove(user);
            JOptionPane.showMessageDialog(null, user.getNome()+" removido da sala "+NumeroDaSala);
        }
        else {
            JOptionPane.showMessageDialog(null, user.getNome()+" não encontrado");
        }
    }
    
    public void print_mensagem(String s) {
        System.out.println(s);
    }    
     
    public Musica play_music(String titulo, String autor) {
        for(Musica m: Musicas) {
            if((m.getTitulo() == titulo) && (m.getAutor() == autor)) {
                return m;
            }
            break;
        }
        return null;
    }
    
}

