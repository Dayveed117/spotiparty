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
    
    private String NomeDaSala;
    private ArrayList<UserNormal> Membros;
    private AdminUser admin;
    private ArrayList<Musica> Musicas;
    private ArrayList<String> Mensagens;
    
    
    public Sala() {
    }
    
    public Sala(String NomeDaSala, UserNormal user) {
        this.NomeDaSala = NomeDaSala;
        this.Membros.add(new UserNormal());
        this.admin = new AdminUser(user,true);
        this.Mensagens.add("Escreva alguma coisa !!!");
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
    
    public String getNomeDaSala() {
        return NomeDaSala;
    }

    public void setNomeDaSala(String NomeDaSala) {
        this.NomeDaSala = NomeDaSala;
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

    public void setAdmin(AdminUser admin) {      //na main apenas o admin poder promover outro admin
        this.admin = admin;
    }
    
    //para remover uma sala basta por a sala toda a null e fazer print de sucesso??
    
    //checkar na main se o current_user é admin para fazer estas operações
    public void adicionar_user(UserNormal user) {
        if(Membros.contains(user)) {
            JOptionPane.showMessageDialog(null, "Utilizador já está na sala");
        }
        else {
            Membros.add(user);
            JOptionPane.showMessageDialog(null, user.getNome()+" juntou-se à sala "+NomeDaSala);
        }
    }
    
    public void remover_user(UserNormal user) {
        if(Membros.contains(user)) {
            Membros.remove(user);
            JOptionPane.showMessageDialog(null, user.getNome()+" removido da sala "+NomeDaSala);
        }
        else {
            JOptionPane.showMessageDialog(null, user.getNome()+" não encontrado");
        }
    }
    
    public void promover(UserNormal user) {
        if(Membros.contains(user)) {
            user = (AdminUser)user;
            JOptionPane.showInputDialog(null,  user.getNome()+"promovido a admin");
        }
        else {
             JOptionPane.showInputDialog(null,"User not found");
        }
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

