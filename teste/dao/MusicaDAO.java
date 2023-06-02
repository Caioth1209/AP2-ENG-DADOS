package teste.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
            String sql = "INSERT INTO musica (titulo, letra, id_categoria) VALUES (?, ?, ?)";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    
                pstm.setString(1, musica.getTitulo());
                pstm.setString(2, musica.getLetra());
                pstm.setInt(3, musica.getIdCategoria());
    
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
    

    public void read() {
        
    }
    
    public void update() {
        
    }
    
    public void delete() {
        
    }

}
