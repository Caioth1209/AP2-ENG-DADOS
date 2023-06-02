package teste.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import teste.model.Musica;
import teste.model.Autor;

public class AutorDAO {
    private Connection connection;

    public AutorDAO() {
    }

    public AutorDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Autor autor) {
        try {
            String sql = "INSERT INTO autor (nome) VALUES (?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, autor.getNome());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        autor.setId(rst.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Autor autor, Musica musica) {
        try {
            String sql = "INSERT INTO autor (nome) VALUES (?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, autor.getNome());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        autor.setId(rst.getInt(1));
                    }
                }
            } 

            String sql2 = "INSERT INTO musicaautor VALUES (?, ?)";

            try (PreparedStatement pstm2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS)) {

                pstm2.setInt(1, musica.getId());
                pstm2.setInt(2, autor.getId());

                pstm2.execute();
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
