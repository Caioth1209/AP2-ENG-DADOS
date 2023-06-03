package teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import teste.model.Categoria;

public class CategoriaDAO {
    
    private Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public Categoria findById(int id) {
        try {
            String sql = "SELECT * FROM categoria WHERE id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
    
                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        Categoria categoria = new Categoria();
                        categoria.setId(rs.getInt("id"));
                        categoria.setNome(rs.getString("nome"));
    
                        return categoria;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
        return null;
    }
    
    // Outros métodos, se necessários
}
