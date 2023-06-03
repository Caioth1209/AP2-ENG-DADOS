package teste.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import teste.model.Categoria;
import teste.model.Musica;
import teste.model.Playlist;
import teste.model.Usuario;

public class PlaylistDAO {

    private Connection connection;

    public PlaylistDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Playlist playlist) {
        try {
            String sql = "INSERT INTO playlist (nome, privado, id_categoria, cpf_usuario, dataCriacao) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, playlist.getNome());
                pstm.setBoolean(2, playlist.isPrivado());
                pstm.setInt(3, playlist.getCategoria().getId());
                pstm.setString(4, playlist.getUsuario().getCpf());
                pstm.setDate(5, new java.sql.Date(playlist.getDataCriacao().getTime()));

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addMusic(int playlistId, Musica musica) {
        try {
            String sql = "INSERT INTO playlistMusica (playlist_id, musica_id) VALUES (?, ?)";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {

                pstm.setInt(1, playlistId);
                pstm.setInt(2, musica.getId());
    
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listen(int playlistId) {
        ArrayList<Musica> musicas = new ArrayList<>();

        try {
            String sql = "SELECT m.id, m.letra FROM musica m INNER JOIN playlistMusica pm ON m.id = pm.musica_id WHERE pm.playlist_id = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, playlistId);

                try (ResultSet rs = pstm.executeQuery()) {
                    while (rs.next()) {
                        int idMusica = rs.getInt("id");
                        String letra = rs.getString("letra");

                        Musica musica = new Musica(idMusica, letra);
                        
                        musicas.add(musica);
                    }
                }
            }

            System.out.println("\nEscutando músicas da playlist:\n");
            if (musicas.isEmpty()) {
                System.out.println("Nenhuma música encontrada.");
            } else {
                for (Musica musica : musicas) {
                    System.out.println(musica.getLetra() + "\n");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Playlist> findByUserCpf(Usuario usuario) {
        ArrayList<Playlist> playlists = new ArrayList<>();

        try {
            String sql = "SELECT p.id, p.nome, p.privado, p.id_categoria, p.cpf_usuario FROM playlist p INNER JOIN categoria c ON p.id_categoria = c.id WHERE (p.privado = FALSE OR (p.privado = TRUE AND p.cpf_usuario = ?)) AND p.cpf_usuario = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, usuario.getCpf());
                pstm.setString(2, usuario.getCpf());

                try (ResultSet rs = pstm.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        boolean privado = rs.getBoolean("privado");
                        int idCategoria = rs.getInt("id_categoria");
                        String cpfUsuario = rs.getString("cpf_usuario");

                        Categoria categoria = new Categoria(idCategoria);
                        Usuario usuarioPlaylist = new Usuario(cpfUsuario);

                        CategoriaDAO cdao = new CategoriaDAO(connection);
                        categoria = cdao.findById(idCategoria);

                        UsuarioDAO udao = new UsuarioDAO(connection);
                        usuarioPlaylist = udao.findByCpf(usuarioPlaylist.getCpf());

                        Playlist playlist = new Playlist(id, nome, privado, categoria, usuarioPlaylist);
                        playlists.add(playlist);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return playlists;
    }

    public ArrayList<Playlist> findByYear(int year) {
        ArrayList<Playlist> playlists = new ArrayList<>();

        try {
            String sql = "SELECT id, nome, privado, id_categoria, cpf_usuario FROM playlist WHERE YEAR(dataCriacao) = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, year);

                try (ResultSet rs = pstm.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        boolean privado = rs.getBoolean("privado");
                        int idCategoria = rs.getInt("id_categoria");
                        String cpfUsuario = rs.getString("cpf_usuario");

                        Categoria categoria = new Categoria(idCategoria);
                        Usuario usuarioPlaylist = new Usuario(cpfUsuario);

                        CategoriaDAO cdao = new CategoriaDAO(connection);
                        categoria = cdao.findById(idCategoria);

                        UsuarioDAO udao = new UsuarioDAO(connection);
                        usuarioPlaylist = udao.findByCpf(usuarioPlaylist.getCpf());

                        Playlist playlist = new Playlist(id, nome, privado, categoria, usuarioPlaylist);
                        playlists.add(playlist);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return playlists;
    }

    public Playlist findByName(String name) {
        try {
            String sql = "SELECT id, nome, privado, id_categoria, cpf_usuario FROM playlist WHERE nome = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, name);

                try (ResultSet rs = pstm.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        boolean privado = rs.getBoolean("privado");
                        int idCategoria = rs.getInt("id_categoria");
                        String cpfUsuario = rs.getString("cpf_usuario");

                        Categoria categoria = new Categoria(idCategoria);
                        Usuario usuarioPlaylist = new Usuario(cpfUsuario);

                        CategoriaDAO cdao = new CategoriaDAO(connection);
                        categoria = cdao.findById(idCategoria);

                        UsuarioDAO udao = new UsuarioDAO(connection);
                        usuarioPlaylist = udao.findByCpf(usuarioPlaylist.getCpf());

                        Playlist playlist = new Playlist(id, nome, privado, categoria, usuarioPlaylist);
                        return playlist;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public void deleteById(int id) {
        try {
            String sql = "DELETE FROM playlist WHERE id = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, id);
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Playlist playlist) {
        try {
            String sql = "UPDATE playlist SET nome = ?, privado = ?, id_categoria = ? WHERE id = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, playlist.getNome());
                pstm.setBoolean(2, playlist.isPrivado());
                pstm.setInt(3, playlist.getCategoria().getId());
                pstm.setInt(4, playlist.getId());

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeMusic(int playlistId, Musica musica) {
        try {
            String sql = "DELETE FROM playlistMusica WHERE playlist_id = ? AND musica_id = ?";
    
            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, playlistId);
                pstm.setInt(2, musica.getId());
    
                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
