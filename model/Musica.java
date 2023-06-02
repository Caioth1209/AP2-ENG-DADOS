import java.util.Date;

public class Musica {
    private int id;
    private String titulo;
    private String letra;
    private Date dataLancamento;
    private int duracao;
    private int censura;
    private int idCategoria;

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
    
    
}
