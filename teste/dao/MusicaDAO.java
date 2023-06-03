package teste.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import teste.model.Autor;
import teste.model.Musica;
import teste.model.Produtor;

public class MusicaDAO {
    
    private Connection connection;

    public MusicaDAO() {
    }

    public MusicaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Musica musica) {
        try {
            String sql = "INSERT INTO musica (titulo, letra, dataLancamento, duracao, censura, id_categoria) VALUES (?, ?, ?, ? , ?, ?)";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    
                pstm.setString(1, musica.getTitulo());
                pstm.setString(2, musica.getLetra());
                if (musica.getDataLancamento() == null) {
                    pstm.setDate(3, null);
                } else {
                    pstm.setDate(3, new java.sql.Date(musica.getDataLancamento().getTime()));
                }
                pstm.setInt(4, musica.getDuracao());
                pstm.setInt(5, musica.getCensura());
                pstm.setInt(6, musica.getIdCategoria());
    
                pstm.execute();
    
                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        musica.setId(rst.getInt(1));

                        for (Produtor produtor : musica.getProdutores()) {
                            ProdutorDAO pdao = new ProdutorDAO(connection);
                            pdao.create(produtor, musica);
                        }

                        for (Autor autor : musica.getAutores()) {
                            AutorDAO adao = new AutorDAO(connection);
                            adao.create(autor, musica);
                        }
                    }
                }
            }
    
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    

    public Musica findByTitle(String titulo) {
        try {
            String sql = "SELECT * FROM musica WHERE titulo = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, titulo);
    
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        Musica musica = new Musica();
                        musica.setId(rs.getInt("id"));
                        musica.setTitulo(rs.getString("titulo"));
                        musica.setLetra(rs.getString("letra"));
                        musica.setDataLancamento(rs.getDate("dataLancamento"));
                        musica.setDuracao(rs.getInt("duracao"));
                        musica.setCensura(rs.getInt("censura"));
                        musica.setIdCategoria(rs.getInt("id_categoria"));
                        return musica;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
        return null;
    }
    
    public ArrayList<Musica> findByAuthorId(Autor autor) {
        try {
            String sql = "SELECT m.* FROM musica m INNER JOIN musicaautor ma ON m.id = ma.musica_id WHERE ma.autor_id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, autor.getId());
    
                try (ResultSet rs = pstm.executeQuery()) {
                    ArrayList<Musica> musicas = new ArrayList<>();
                    while (rs.next()) {
                        Musica musica = new Musica();
                        musica.setId(rs.getInt("id"));
                        musica.setTitulo(rs.getString("titulo"));
                        musica.setLetra(rs.getString("letra"));
                        musica.setDataLancamento(rs.getDate("dataLancamento"));
                        musica.setDuracao(rs.getInt("duracao"));
                        musica.setCensura(rs.getInt("censura"));
                        musica.setIdCategoria(rs.getInt("id_categoria"));
                        musicas.add(musica);
                    }
                    return musicas;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Musica> findByProducerId(Produtor produtor) {
        try {
            String sql = "SELECT m.* FROM musica m INNER JOIN musicaprodutor mp ON m.id = mp.musica_id WHERE mp.produtor_id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, produtor.getId());
    
                try (ResultSet rs = pstm.executeQuery()) {
                    ArrayList<Musica> musicas = new ArrayList<>();
                    while (rs.next()) {
                        Musica musica = new Musica();
                        musica.setId(rs.getInt("id"));
                        musica.setTitulo(rs.getString("titulo"));
                        musica.setLetra(rs.getString("letra"));
                        musica.setDataLancamento(rs.getDate("dataLancamento"));
                        musica.setDuracao(rs.getInt("duracao"));
                        musica.setCensura(rs.getInt("censura"));
                        musica.setIdCategoria(rs.getInt("id_categoria"));
                        musicas.add(musica);
                    }
                    return musicas;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void viewMusicData(int id) {
        try {
            String sql = "SELECT titulo, dataLancamento, duracao, censura, id_categoria FROM musica WHERE id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
    
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        String titulo = rs.getString("titulo");
                        Date dataLancamento = rs.getDate("dataLancamento");
                        int duracao = rs.getInt("duracao");
                        int censura = rs.getInt("censura");
                        int idCategoria = rs.getInt("id_categoria");
    
                        System.out.println("\nTítulo: " + titulo);
                        System.out.println("Data de Lançamento: " + dataLancamento);
                        System.out.println("Duração: " + duracao);
                        System.out.println("Censura: " + censura);
                        System.out.println("Categoria: " + idCategoria + "\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void viewLyrics(int id) {
        try {
            String sql = "SELECT letra FROM musica WHERE id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
    
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        String letra = rs.getString("letra");
                        System.out.println("\nLetra da música: " + letra + "\n");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void deleteById(int id) {
        try {
            String sql = "DELETE FROM musica WHERE id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
    
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void update(Musica musica) {
        try {
            String sql = "UPDATE musica SET titulo = ?, letra = ?, dataLancamento = ?, duracao = ?, censura = ?, id_categoria = ? WHERE id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, musica.getTitulo());
                pstm.setString(2, musica.getLetra());
                pstm.setDate(3, new java.sql.Date(musica.getDataLancamento().getTime()));
                pstm.setInt(4, musica.getDuracao());
                pstm.setInt(5, musica.getCensura());
                pstm.setInt(6, musica.getIdCategoria());
                pstm.setInt(7, musica.getId());
    
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    

}
