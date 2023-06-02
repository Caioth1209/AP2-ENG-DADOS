package teste.view;
import java.sql.Connection;
import java.sql.SQLException;

import teste.dao.AutorDAO;
import teste.dao.ConexaoDB;
import teste.dao.MusicaDAO;
import teste.dao.ProdutorDAO;
import teste.model.Autor;
import teste.model.Musica;
import teste.model.Produtor;

public class Principal {
    public static void main(String[] args) throws SQLException {

        try{
            ConexaoDB conexaoDB = new ConexaoDB();
            Connection conexao = conexaoDB.recuperarConexao();

            ///////////////////////////////////////////////////////////////

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

            System.out.println("Musica criada com autor e produtor!\n");

            ///////////////////////////////////////////////////////////////

            produtor = new Produtor("Loui");

            ProdutorDAO pdao = new ProdutorDAO(conexao);
            pdao.create(produtor);

            System.out.println("Produtor criado sem música!\n");

            ///////////////////////////////////////////////////////////////

            autor = new Autor("Cakiw");
            AutorDAO adao = new AutorDAO(conexao);
            adao.create(autor);

            System.out.println("Autor criado sem música!\n");

            ///////////////////////////////////////////////////////////////

        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        
        // Criar autor sem musica
        // Buscar autor pelo nome
        // atualizar autor
        // Deletar autor pelo nome

        // Criar produtor sem musica
        // Buscar produtor pelo nome
        // atualizar produtor
        // Deletar produtor pelo nome

        // Buscar musica pelo titulo
        // Buscar musica pelo autor
        // Buscar musica pelo produtor
        // Visualizar dados de musica exceto a letra
        // Visualizar letra da musica
        // Deletar musica pelo titulo
        // Atualizar musica

        // Criar usuario
        // Buscar usuario pelo nome
        // Deletar usuario pelo nome
        // Atualizar usuario

        // Criar playlist
        // Visualizar letras de todas as musicas da playlist
        // Buscar playlist pelo nome
        // Buscar playlist pelo usuario
        // Buscar playlist pelo ano
        // Deletar playlist pelo nome
        // Atualizar playlist
    }
}
