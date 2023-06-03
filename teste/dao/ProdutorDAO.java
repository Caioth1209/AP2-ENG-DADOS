package teste.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import teste.model.Musica;
import teste.model.Produtor;

public class ProdutorDAO {
    private Connection connection;

    public ProdutorDAO() {
    }

    public ProdutorDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Produtor produtor) {
        try {
            String sql = "INSERT INTO produtor (nome) VALUES (?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, produtor.getNome());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        produtor.setId(rst.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Produtor produtor, Musica musica) {
        try {
            String sql = "INSERT INTO produtor (nome) VALUES (?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1, produtor.getNome());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        produtor.setId(rst.getInt(1));
                    }
                }
            } 

            String sql2 = "INSERT INTO musicaprodutor VALUES (?, ?)";

            try (PreparedStatement pstm2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS)) {

                pstm2.setInt(1, musica.getId());
                pstm2.setInt(2, produtor.getId());

                pstm2.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public Produtor findByName(String nome) {
        try {
            String sql = "SELECT * FROM produtor WHERE nome = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, nome);
    
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        Produtor produtor = new Produtor();
                        produtor.setId(rs.getInt("id"));
                        produtor.setNome(rs.getString("nome"));
                        return produtor;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
        return null;
    }
    
    public void update(Produtor produtor) {
        try {
            String sql = "UPDATE produtor SET nome = ? WHERE id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, produtor.getNome());
                pstm.setInt(2, produtor.getId());
    
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deleteById(int id) {
        try {
            String sql = "DELETE FROM produtor WHERE id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
    
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    

}
