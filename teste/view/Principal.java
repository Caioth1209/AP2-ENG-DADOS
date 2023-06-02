package teste.view;
import java.sql.Connection;
import java.sql.SQLException;

import teste.dao.AutorDAO;
import teste.dao.ConexaoDB;
import teste.dao.MusicaDAO;
import teste.model.Autor;
import teste.model.Musica;
import teste.model.Produtor;

public class Principal {
    public static void main(String[] args) throws SQLException {

        try{
            ConexaoDB conexaoDB = new ConexaoDB();
            Connection conexao = conexaoDB.recuperarConexao();

            // cria musica
            Musica musica = new Musica("Creu", "CreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreu", 2);

            // cria autor
            Autor autor = new Autor("Trem");
            musica.addAutor(autor);
            
            // cria produtor
            Produtor produtor = new Produtor("Bala");
            musica.addProdutor(produtor);

            MusicaDAO musicaDAO = new MusicaDAO(conexao);
            musicaDAO.create(musica);

            
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        
        // Buscar autor pelo nome
        // Buscar produtor pelo nome
        // Buscar musica pelo titulo
        // Buscar musica pelo autor
        // Buscar musica pelo produtor

    }
}
