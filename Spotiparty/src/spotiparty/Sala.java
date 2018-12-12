/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotiparty;
import java.util.ArrayList;
import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;
/**
 *
 * @author a40284
 */
public class Sala {
    
    private String NomeDaSala;
    private ArrayList<User> Membros;
    private AdminUser admin;
    
    
    /*remover user
    adicionar user
    promover a admin
    clear sala
    play music
    votação a escolher musica
    */

    
    
    public String getNomeDaSala() {
        return NomeDaSala;
    }

    public void setNomeDaSala(String NomeDaSala) {
        this.NomeDaSala = NomeDaSala;
    }

    public ArrayList<User> getMembros() {
        return Membros;
    }

    public void setMembross(ArrayList<User> Membros) {
        this.Membros = Membros;
    }

    public AdminUser getAdmin() {
        return admin;
    }

    public void setAdmin(AdminUser admin) {      //na main apenas o admin poder promover outro admin
        this.admin = admin;
    }
    
    //para remover uma sala basta por a sala toda a null e fazer print de sucesso??
    
    public void adicionar_user(Sala sala, User user) {
        if(Membros.contains(user)) {
            JOptionPane.showMessageDialog(null, "Utilizador já está na sala");
        }
        else {
            Membros.add(user);
            JOptionPane.showMessageDialog(null, +user.getNome()+" juntou-se à sala "+NomeDaSala);
        }
    }
    
    public void remover_user(Sala sala, User user) {
        if(Membros.contains(user)) {
            Membros.remove(user);
            JOptionPane.showMessageDialog(null, user.getNome()+" removido da sala "+NomeDaSala);
        }
        else {
            JOptionPane.showMessageDialog(null, user.getNome()+" não encontrado");
        }
    }
}
