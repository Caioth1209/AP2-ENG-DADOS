package teste.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import teste.model.Usuario;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuario (cpf, nome, dataNasc, numeroCartao) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, usuario.getCpf());
                pstm.setString(2, usuario.getNome());
                pstm.setDate(3, new java.sql.Date(usuario.getDataNascimento().getTime()));
                pstm.setInt(4, usuario.getNumeroCartao());

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario findByCpf(String cpf) {
        try {
            String sql = "SELECT nome, dataNasc, numeroCartao FROM usuario WHERE cpf = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cpf);

                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        String nome = rs.getString("nome");
                        java.sql.Date dataNascimento = rs.getDate("dataNasc");
                        int numeroCartao = rs.getInt("numeroCartao");
                        Usuario usuario = new Usuario(cpf, nome, dataNascimento, numeroCartao);

                        return usuario;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void delete(String cpf) {
        try {
            String sql = "DELETE FROM usuario WHERE cpf = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cpf);
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Usuario usuario) {
        try {
            String sql = "UPDATE usuario SET nome = ?, dataNasc = ?, numeroCartao = ? WHERE cpf = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, usuario.getNome());
                pstm.setDate(2, new java.sql.Date(usuario.getDataNascimento().getTime()));
                pstm.setInt(3, usuario.getNumeroCartao());
                pstm.setString(4, usuario.getCpf());

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
