package teste.view;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import teste.dao.AutorDAO;
import teste.dao.CategoriaDAO;
import teste.dao.ConexaoDB;
import teste.dao.MusicaDAO;
import teste.dao.PlaylistDAO;
import teste.dao.ProdutorDAO;
import teste.dao.UsuarioDAO;
import teste.model.Autor;
import teste.model.Categoria;
import teste.model.Musica;
import teste.model.Playlist;
import teste.model.Produtor;
import teste.model.Usuario;

public class Principal {
    public static void main(String[] args) throws SQLException {

        try{
            ConexaoDB conexaoDB = new ConexaoDB();
            Connection conexao = conexaoDB.recuperarConexao();

            ////////// CRUD DE MUSICA /////////////////////////

            System.out.println("\n\nCRUD DE MUSICA\n");

            CategoriaDAO cdao = new CategoriaDAO(conexao);

            Categoria categoria = cdao.findById(2);

            // criar musica
            Musica musica = new Musica("Creu", "CreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreuCreu", categoria);

            Autor autor = new Autor("Trem");
            musica.addAutor(autor);
            
            Produtor produtor = new Produtor("Bala");
            musica.addProdutor(produtor);

            MusicaDAO musicaDAO = new MusicaDAO(conexao);
            musicaDAO.create(musica);

            System.out.println("Musica criada com autor e produtor.\n");

            // buscar musica pelo titulo
            musica = musicaDAO.findByTitle("Creu");
            System.out.println("Buscando musica pelo titulo: Creu");

            if(musica != null){
                System.out.println("Musica encontrada com titulo: " + musica.getTitulo());
                System.out.println("E com id: " + musica.getId() + ".\n");
            } else {
                System.out.println("Musica não encontrada.\n");
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

            Musica musica2 = new Musica("Sereia me perdoa", "Sereiaaa, me perdoaaa", new Date(System.currentTimeMillis()) ,120, 18, categoria);

            Autor autor2 = new Autor("Ryan Sp");
            musica2.addAutor(autor2);
            
            Produtor produtor2 = new Produtor("Kizzy");
            musica2.addProdutor(produtor2);

            musicaDAO.create(musica2);

            System.out.println("Musica criada com autor e produtor.\n");

            Musica musica3 = new Musica("Revoada do Tubarão", "revoada meu fii", new Date(System.currentTimeMillis()) ,120, 18, categoria);

            Autor autor3 = new Autor("MC hariel");
            musica3.addAutor(autor2);
            musica3.addAutor(autor3);
            
            Produtor produtor3 = new Produtor("Produtor brabo");
            musica3.addProdutor(produtor2);
            musica3.addProdutor(produtor3);

            musicaDAO.create(musica3);

            System.out.println("Musica criada com autor e produtor.\n");

            ////////////////  CRUD DE PRODUTOR ///////////////////////////////////////////////

            System.out.println("\n\nCRUD DE PRODUTOR\n");

           // criando produtor
           produtor = new Produtor("Produtor doido");
           ProdutorDAO pdao = new ProdutorDAO(conexao);
           pdao.create(produtor);
           System.out.print("Produtor criado sem música e com nome: ");
           System.out.println(produtor.getNome() + ".\n");

           produtor = new Produtor("Batista");
           pdao.create(produtor);
           System.out.print("Produtor criado sem música e com nome: ");
           System.out.println(produtor.getNome() + ".\n");

           // buscando produtor pelo nome
           produtor = pdao.findByName("Batista");
           System.out.println("Buscando autor pelo nome: Batista");

           if(produtor != null){
               System.out.println("Produtor encontrado com nome: " + produtor.getNome());
               System.out.println("E com id: " + produtor.getId() + ".\n");
           } else {
               System.out.println("Produtor não encontrado.\n");
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
               System.out.println("Produtor não encontrado.\n");
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
            System.out.println(autor.getNome() + ".\n");

            autor = new Autor("Juanito");
            adao.create(autor);
            System.out.print("Autor criado sem música e com nome: ");
            System.out.println(autor.getNome() + ".\n");

            // buscando autor pelo nome
            autor = adao.findByName("Caioba");
            System.out.println("Buscando autor pelo nome: Caioba");

            if(autor != null){
                System.out.println("Autor encontrado com nome: " + autor.getNome());
                System.out.println("E com id: " + autor.getId() + ".\n");
            } else {
                System.out.println("Autor não encontrado.\n");
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
                System.out.println("Autor não encontrado.\n");
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
                System.out.println("Usuário não encontrado.\n");
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
                System.out.println("Usuário não encontrado.\n");
            }

            // deletando usuario
            System.out.println("\nDeletando usuario com cpf: " + user.getCpf());
            udao.delete(user.getCpf());

            Usuario user2 = new Usuario("11198173651", "Luiz Fernando", new Date(Date.valueOf("2006-03-09").getTime()) ,231);
            udao.create(user2);
            System.out.print("\nUsuario criado com cpf: ");
            System.out.println(user2.getCpf() + "\n");

            Usuario user3 = new Usuario("11100011291", "Lucas Almeida", new Date(Date.valueOf("2001-03-02").getTime()) ,415);
            udao.create(user3);
            System.out.print("\nUsuario criado com cpf: ");
            System.out.println(user3.getCpf() + "\n");


            //////////////////// CRUD DE PLAYLIST ///////////////////////////////////////////

            System.out.println("\n\nCRUD DE PLAYLIST\n");

            // criar playlist
            Playlist playlist = new Playlist("Playlist do Caio", false, categoria, user2, new Date(Date.valueOf("2023-01-01").getTime()));
            PlaylistDAO pldao = new PlaylistDAO(conexao);
            pldao.create(playlist);

            System.out.print("\nPlaylist criada com nome: ");
            System.out.println(playlist.getNome() + "\n");
            
            // buscar playlists pelo usuario
            ArrayList<Playlist> playlistsUser = pldao.findByUserCpf(user2);
            System.out.println("\nBuscando playlists do usuario com cpf: " + user2.getCpf());
            
            if(playlistsUser.isEmpty()){
                System.out.println("Nenhuma playlist encontrada.\n");
            } else {
                for(Playlist pl : playlistsUser){
                    System.out.println(pl.getId() + ". " + pl.getNome());
                }
            }

            // buscar playlist pelo nome
            playlist = pldao.findByName("Playlist do Caio");
            System.out.println("\nBuscando playlist pelo nome: Playlist do Caio");

            if(playlist != null){
                System.out.println("Playlist encontrada com nome: " + playlist.getNome());
                System.out.println("E com id: " + playlist.getId() + ".\n");
            } else {
                System.out.println("Playlist não encontrada.\n");
            }

            // atualizando playlist
            System.out.println("\nAtualizando playlist com id: " + playlist.getId());
            playlist.setNome("Playlist do Caio Araujo");
            playlist.setPrivado(true);
            pldao.update(playlist);

            playlist = pldao.findByName("Playlist do Caio Araujo");
            System.out.println("\nBuscando playlist pelo nome: Playlist do Caio Araujo");

            if(playlist != null){
                System.out.println("Playlist encontrada com nome: " + playlist.getNome());
                System.out.println("E com id: " + playlist.getId() + ".\n");
            } else {
                System.out.println("Playlist não encontrada.\n");
            }

            // deletando playlist
            System.out.println("\nDeletando playlist com id: " + playlist.getId());
            pldao.deleteById(playlist.getId());

            Playlist playlist2 = new Playlist("Playlist do Lucas", false, categoria, user3, new Date(Date.valueOf("2007-01-01").getTime()));
            pldao.create(playlist2);

            System.out.print("\nPlaylist criada com nome: ");
            System.out.println(playlist2.getNome() + "\n");

            System.out.println("\nAdicionando musicas a playlist com id: 2");
            pldao.addMusic(2, musica2);
            pldao.addMusic(2, musica3);

            // escutando musicas da playlist
            System.out.println("\nEscutando músicas da playlist com id: 2");
            pldao.listen(2);

            // buscando playlists do usuario
            playlistsUser = pldao.findByUserCpf(user3);
            System.out.println("\nBuscando playlists do usuario com cpf: " + user3.getCpf());

            if(playlistsUser.isEmpty()){
                System.out.println("Nenhuma playlist encontrada.\n");
            } else {
                for(Playlist pl : playlistsUser){
                    System.out.println(pl.getId() + ". " + pl.getNome());
                }
            }

            // escutando musicas da primeira playlist do usuario
            System.out.println("\nEscutando músicas da playlist com id: " + playlistsUser.get(0).getId());
            System.out.println("Do usuário com cpf: " + user3.getCpf() + "\n");
            pldao.listen(playlistsUser.get(0).getId());

            // buscando playlists pelo ano
            playlistsUser = pldao.findByYear(2007);

            System.out.println("\nBuscando playlists do ano: 2007");

            if (playlistsUser.isEmpty()) {
                System.out.println("Nenhuma playlist encontrada.");
            } else {
                for (Playlist pl : playlistsUser) {
                    System.out.println(pl.getId() + ". " + pl.getNome());
                }
            }

            // buscando playlists pelo ano
            playlistsUser = pldao.findByYear(2023);

            System.out.println("\nBuscando playlists do ano: 2023");

            if (playlistsUser.isEmpty()) {
                System.out.println("Nenhuma playlist encontrada.");
            } else {
                for (Playlist pl : playlistsUser) {
                    System.out.println(pl.getId() + ". " + pl.getNome());
                }
            }

        } catch (Error e) {
            System.out.println(e.getMessage());

        }
    }
}
