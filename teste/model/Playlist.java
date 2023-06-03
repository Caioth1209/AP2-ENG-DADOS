package teste.model;

import java.util.ArrayList;
import java.util.Date;

public class Playlist {
    private int id;
    private String nome;
    private boolean privado;
    private Date dataCriacao;
    private Categoria categoria;
    private Usuario usuario;
    private ArrayList<Musica> musicas = new ArrayList<Musica>();

    public Playlist(int id, String nome, boolean privado, Categoria categoria, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.privado = privado;
        this.categoria = categoria;
        this.usuario = usuario;
    }

    public Playlist(int id, String nome, boolean privado, Categoria categoria, Usuario usuario, Date dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.privado = privado;
        this.categoria = categoria;
        this.usuario = usuario;
        this.dataCriacao = dataCriacao;
    }

    public Playlist(String nome, boolean privado, Categoria categoria, Usuario usuario,  Date dataCriacao) {
        this.nome = nome;
        this.privado = privado;
        this.categoria = categoria;
        this.usuario = usuario;
        this.dataCriacao = dataCriacao;
    }

    public Playlist(String nome, boolean privado, Categoria categoria, Usuario usuario) {
        this.nome = nome;
        this.privado = privado;
        this.categoria = categoria;
        this.usuario = usuario;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isPrivado() {
        return privado;
    }
    public void setPrivado(boolean privado) {
        this.privado = privado;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    public void addMusica(Musica musica) {
        this.musicas.add(musica);
    }

    public void removeMusica(Musica musica) {
        this.musicas.remove(musica);
    }
    
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }
}
