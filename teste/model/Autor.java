package teste.model;
public class Autor {
    private int id;
    private String nome;

    public Autor() {
    }
    
    public Autor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Autor(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int idAutor) {
        this.id = idAutor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
