package teste.view;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import teste.dao.AutorDAO;
import teste.dao.ConexaoDB;
import teste.dao.MusicaDAO;
import teste.dao.ProdutorDAO;
import teste.dao.UsuarioDAO;
import teste.model.Autor;
import teste.model.Musica;
import teste.model.Produtor;
import teste.model.Usuario;

public class Principal {
    public static void main(String[] args) throws SQLException {

        try{
            ConexaoDB conexaoDB = new ConexaoDB();
            Connection conexao = conexaoDB.recuperarConexao();

            ////////// CRUD DE MUSICA /////////////////////////

            System.out.println("\n\nCRUD DE MUSICA\n");

            // criar musica
            Musica musica = new Musica("Creu", "CreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreu", 2);

            Autor autor = new Autor("Trem");
            musica.addAutor(autor);
            
            Produtor produtor = new Produtor("Bala");
            musica.addProdutor(produtor);

            MusicaDAO musicaDAO = new MusicaDAO(conexao);
            musicaDAO.create(musica);

            System.out.println("Musica criada com autor e produtor!\n");

            // buscar musica pelo titulo
            musica = musicaDAO.findByTitle("Creu");
            System.out.println("Buscando musica pelo titulo: Creu");

            if(musica != null){
                System.out.println("Musica encontrada com titulo: " + musica.getTitulo());
                System.out.println("E com id: " + musica.getId() + ".\n");
            } else {
                System.out.println("Musica não encontrada!\n");
            }


            // buscando musicas do autor
            ArrayList<Musica> musicas = musicaDAO.findByAuthorId(autor);
            System.out.println("\nBuscando musicas do autor: " + autor.getNome());

            System.out.println("Musicas encontradas: ");
            if (musicas.isEmpty()) {
                System.out.println("Nenhuma musica encontrada!");
            } else {
                for(Musica m : musicas){
                    System.out.println(m.getId() + ". " +m.getTitulo());
                }
            }
            // buscando musicas do produtor
            musicas = musicaDAO.findByProducerId(produtor);
            System.out.println("\nBuscando musicas do produtor: " + produtor.getNome());

            System.out.println("Musicas encontradas: ");
            if (musicas.isEmpty()) {
                System.out.println("Nenhuma musica encontrada!");
            } else {
                for(Musica m : musicas){
                    System.out.println(m.getId() + ". " +m.getTitulo());
                }
            }
            
            // buscando dados da musica exceto a letra
            System.out.println("\nBuscando dados da musica exceto a letra do id: " + musica.getId() + "\n");
            musicaDAO.viewMusicData(musica.getId());

            // buscando letra da musica
            System.out.println("\nBuscando letra da musica do id: " + musica.getId() + "\n");
            musicaDAO.viewLyrics(musica.getId());

            // atualizando musica
            System.out.println("\nAtualizando musica do id: " + musica.getId() + "\n");
            musica.setTitulo("Creu dos amigo");
            musica.setCensura(21);
            musica.setDuracao(100);
            musica.setDataLancamento(new Date(System.currentTimeMillis()));
            musicaDAO.update(musica);

            // deletando musica
            System.out.println("\nDeletando musica do id: " + musica.getId() + "\n");
            musicaDAO.deleteById(musica.getId());

            Musica musica2 = new Musica("Sereia me perdoa", "Sereiaaa, me perdoaaa", new Date(System.currentTimeMillis()) ,120, 18, 2);

            Autor autor2 = new Autor("Ryan Sp");
            musica2.addAutor(autor2);
            
            Produtor produtor2 = new Produtor("Kizzy");
            musica2.addProdutor(produtor2);

            musicaDAO.create(musica2);

            System.out.println("Musica criada com autor e produtor!\n");

            ////////////////  CRUD DE PRODUTOR ///////////////////////////////////////////////

            System.out.println("\n\nCRUD DE PRODUTOR\n");

           // criando produtor
           produtor = new Produtor("Produtor doido");
           ProdutorDAO pdao = new ProdutorDAO(conexao);
           pdao.create(produtor);
           System.out.print("Produtor criado sem música e com nome: ");
           System.out.println(produtor.getNome() + "!\n");

           produtor = new Produtor("Batista");
           pdao.create(produtor);
           System.out.print("Produtor criado sem música e com nome: ");
           System.out.println(produtor.getNome() + "!\n");

           // buscando produtor pelo nome
           produtor = pdao.findByName("Batista");
           System.out.println("Buscando autor pelo nome: Batista");

           if(produtor != null){
               System.out.println("Produtor encontrado com nome: " + produtor.getNome());
               System.out.println("E com id: " + produtor.getId() + ".\n");
           } else {
               System.out.println("Produtor não encontrado!\n");
           }

           // atualizando produtor com id 2 para nome "Raniel"
           System.out.println("Atualizando produtor com id " + produtor.getId() + " para nome Raniel");
           produtor.setNome("Raniel");
           pdao.update(produtor);

           // buscando produtor pelo nome
           produtor = pdao.findByName("Raniel");
           System.out.println("Buscando produtor pelo nome: Raniel");

           if(produtor != null){
               System.out.println("Produtor encontrado com nome: " + produtor.getNome());
               System.out.println("E com id: " + produtor.getId() + ".\n");
           } else {
               System.out.println("Produtor não encontrado!\n");
           }


           // deletando produtor com id 2
           System.out.println("Deletando produtor com id: 2");
           pdao.deleteById(2);

            // //////// CRUD DE AUTOR //////////////////////

            System.out.println("\n\nCRUD DE AUTOR\n");

            // criando autor
            autor = new Autor("Caioba");
            AutorDAO adao = new AutorDAO(conexao);
            adao.create(autor);
            System.out.print("Autor criado sem música e com nome: ");
            System.out.println(autor.getNome() + "!\n");

            autor = new Autor("Juanito");
            adao.create(autor);
            System.out.print("Autor criado sem música e com nome: ");
            System.out.println(autor.getNome() + "!\n");

            // buscando autor pelo nome
            autor = adao.findByName("Caioba");
            System.out.println("Buscando autor pelo nome: Caioba");

            if(autor != null){
                System.out.println("Autor encontrado com nome: " + autor.getNome());
                System.out.println("E com id: " + autor.getId() + ".\n");
            } else {
                System.out.println("Autor não encontrado!\n");
            }

            // atualizando autor com id 2 para nome "Peter Parker"
            System.out.println("Atualizando autor com id " + autor.getId() + " para nome Peter Parker");
            autor.setNome("Peter Parker");
            adao.update(autor);

            // buscando autor pelo nome
            autor = adao.findByName("Peter Parker");
            System.out.println("Buscando autor pelo nome: Peter Parker");

            if(autor != null){
                System.out.println("Autor encontrado com nome: " + autor.getNome());
                System.out.println("E com id: " + autor.getId() + ".\n");
            } else {
                System.out.println("Autor não encontrado!\n");
            }


            // deletando autor com id 2
            System.out.println("Deletando autor com id: 2");
            adao.deleteById(2);

            //////////////////// CRUD DE USUARIO ///////////////////////////////////////////

            System.out.println("\n\nCRUD DE USUARIO\n");

            // criar usuario
            Usuario user = new Usuario("17485163701", "Caio da Luz", new Date(Date.valueOf("2004-06-09").getTime()) ,123);
            UsuarioDAO udao = new UsuarioDAO(conexao);
            udao.create(user);
            System.out.print("\nUsuario criado com cpf: ");
            System.out.println(user.getCpf() + "\n");

            // buscar usuario pelo cpf
            user = udao.findByCpf("17485163701");
            System.out.println("\nBuscando usuário pelo cpf: 17485163701");

            if(user != null){
                System.out.println("Usuário encontrado com nome: " + user.getNome());
                System.out.println("E com cpf: " + user.getCpf() + ".\n");
            } else {
                System.out.println("Usuário não encontrado!\n");
            }

            // atualizando usuario
            System.out.println("\nAtualizando usuario com cpf: " + user.getCpf());
            user.setNome("Caio Araujo da Luz");
            user.setNumeroCartao(321);
            udao.update(user);

            user = udao.findByCpf("17485163701");
            System.out.println("\nBuscando usuário pelo cpf: 17485163701");

            if(user != null){
                System.out.println("Usuário encontrado com nome: " + user.getNome());
                System.out.println("E com cpf: " + user.getCpf() + ".\n");
            } else {
                System.out.println("Usuário não encontrado!\n");
            }

            // deletando usuario
            System.out.println("\nDeletando usuario com cpf: " + user.getCpf());
            udao.delete(user.getCpf());

            user = new Usuario("11198173651", "Luiz Fernando", new Date(Date.valueOf("2006-03-09").getTime()) ,231);
            udao.create(user);
            System.out.print("\nUsuario criado com cpf: ");
            System.out.println(user.getCpf() + "\n");

        } catch (Error e) {
            System.out.println(e.getMessage());

        }
        
        // Criar playlist
        // Visualizar letras de todas as musicas da playlist
        // Buscar playlist pelo nome
        // Buscar playlist pelo usuario
        // Buscar playlist pelo ano
        // Deletar playlist pelo nome
        // Atualizar playlist
    }
}
