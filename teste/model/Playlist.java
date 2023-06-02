package teste.model;
public class Playlist {
    private int id;
    private String nome;
    private boolean privado;
    private Categoria categoria;
    private Usuario usuario;

    public Playlist(int id, String nome, boolean privado, Categoria categoria, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.privado = privado;
        this.categoria = categoria;
        this.usuario = usuario;
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

    
}
