/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spotiparty;

import java.util.Objects;

/**
 *
 * @author a40284
 */
public class Musica {
    
    private double duracao, rating;
    private String titulo, autor, genero, album;
    
    public Musica() {
        
    }
    
    public Musica(double duracao, double rating, String titulo, String autor, String album, String genero) {
        this.duracao = duracao;
        this.rating = rating;              //tem que ser um double de 0 a 5 especificado no main
        this.titulo = titulo;
        this.autor = autor;
        this.album = album;
        this.genero = genero;
        
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    
    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj != null && this.getClass() == obj.getClass()) {
            Musica temp = (Musica)obj;
            return ((album.equals(temp.getAlbum())) && (autor.equals(temp.getAutor())) && (this.getDuracao() == temp.getDuracao())
                    && genero.equals(temp.genero) && this.getRating() == temp.getRating() && titulo.equals(temp.getTitulo()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.titulo);
        hash = 71 * hash + Objects.hashCode(this.autor);
        hash = 71 * hash + Objects.hashCode(this.genero);
        hash = 71 * hash + Objects.hashCode(this.album);
        return hash;
    }
    
    @Override
    public String toString() {
        return("\nTitulo: "+titulo+"\nArtista: "+autor+"; Album: "+album+
                "; Genero: " +genero+"\nDuração: "+duracao+"Rating: "+rating+"\n");
    }
    
}
