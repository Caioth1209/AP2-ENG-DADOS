package teste.model;
public class Produtor {
    private int id;
    private String nome;

    public Produtor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Produtor(String nome) {
        this.nome = nome;
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
    
    
}
