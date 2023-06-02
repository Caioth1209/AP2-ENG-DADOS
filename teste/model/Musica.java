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
    private int idCategoria;
    private ArrayList<Autor> autores = new ArrayList<Autor>();
    private ArrayList<Produtor> produtores = new ArrayList<Produtor>();

    public Musica(int id, String titulo, String letra, Date dataLancamento, int duracao, int censura, int idCategoria) {
        this.id = id;
        this.titulo = titulo;
        this.letra = letra;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.censura = censura;
        this.idCategoria = idCategoria;
    }

    public Musica(String titulo, String letra, Date dataLancamento, int duracao, int censura, int idCategoria) {
        this.titulo = titulo;
        this.letra = letra;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.censura = censura;
        this.idCategoria = idCategoria;
    }

    public Musica(String titulo, String letra, int idCategoria) {
        this.titulo = titulo;
        this.letra = letra;
        this.idCategoria = idCategoria;
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
    public int getIdCategoria() {
        return idCategoria;
    }
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
}
