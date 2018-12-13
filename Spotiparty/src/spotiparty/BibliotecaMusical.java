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
public class BibliotecaMusical {
    
    private ArrayList<Musica> Musicas;
    
    public BibliotecaMusical() {
        Musicas = null;
    }
            
    public ArrayList<Musica> getMusicas() {
        return Musicas;
    }

    public void setMusicas(ArrayList<Musica> Musicas) {
        this.Musicas = Musicas;
    }
    
    public void adicionar_Musica(Musica mus) {
        if(Musicas.contains(mus)) {
              JOptionPane.showMessageDialog(null, "Essa musica já esta na biblioteca!");
        }
        else {
            Musicas.add(mus);
            JOptionPane.showMessageDialog(null, "Música adicionada com sucesso");
        }
    }
    
    public void remover_Musica(Musica mus) {
        if(Musicas.contains(mus)) {
            Musicas.remove(mus);
            JOptionPane.showMessageDialog(null, "Musica removida da Biblioteca");
        }
        else {
            JOptionPane.showMessageDialog(null, "Musica não encontrada");
        }
    }
    
    @Override
    public String toString() {
        String s = "";
        for(Musica m: Musicas) {
            s += m.toString();
        }
        return(s);
    }
    
    public void verificar_musica(Musica mus) {
        if(Musicas.contains(mus)) {
            JOptionPane.showMessageDialog(null, "A música está na biblioteca");
        }
        else {
            JOptionPane.showMessageDialog(null, "A música não está na biblitoteca");
        }
    }
    
}
