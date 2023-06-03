package teste.model;
import java.util.ArrayList;
import java.util.Date;

public class Musica {
    private int id;
    private String titulo;
    private String letra;
    private Date dataLancamento;
    private int duracao;
    private int censura;
    private Categoria categoria;
    private ArrayList<Autor> autores = new ArrayList<Autor>();
    private ArrayList<Produtor> produtores = new ArrayList<Produtor>();
    private ArrayList<Playlist> playlists = new ArrayList<Playlist>();

    public Musica() {
    }

    public Musica(int id, String letra) {
        this.id = id;
        this.letra = letra;
    }

    public Musica(int id, String titulo, String letra, Date dataLancamento, int duracao, int censura, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.letra = letra;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.censura = censura;
        this.categoria = categoria;
    }

    public Musica(String titulo, String letra, Date dataLancamento, int duracao, int censura, Categoria categoria) {
        this.titulo = titulo;
        this.letra = letra;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.censura = censura;
        this.categoria = categoria;
    }

    public Musica(String titulo, String letra, Categoria categoria) {
        this.titulo = titulo;
        this.letra = letra;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getLetra() {
        return letra;
    }
    public void setLetra(String letra) {
        this.letra = letra;
    }
    public Date getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public int getDuracao() {
        return duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public int getCensura() {
        return censura;
    }
    public void setCensura(int censura) {
        this.censura = censura;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void removeAutor(Autor autor) {
        this.autores.remove(autor);
    }

    public ArrayList<Produtor> getProdutores() {
        return produtores;
    }

    public void setProdutores(ArrayList<Produtor> produtores) {
        this.produtores = produtores;
    }

    public void addProdutor(Produtor produtor) {
        this.produtores.add(produtor);
    }

    public void removeProdutor(Produtor produtor) {
        this.produtores.remove(produtor);
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
    }

}
