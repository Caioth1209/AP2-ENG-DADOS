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
        
        // Criar autor sem musica
        // Buscar autor pelo nome
        // Deletar autor pelo nome

        // Criar produtor sem musica
        // Buscar produtor pelo nome
        // Deletar produtor pelo nome

        // Criar musica com autor e produtor
        // Buscar musica pelo titulo
        // Buscar musica pelo autor
        // Buscar musica pelo produtor
        // Visualizar dados de musica exceto a letra
        // Visualizar letra da musica
        // Deletar musica pelo titulo

        // Criar usuario
        // Buscar usuario pelo nome
        // Deletar usuario pelo nome

        // Criar playlist

    }
}
