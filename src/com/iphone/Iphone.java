package com.iphone;

import com.iphone.navegador.NavegadorInternet;
import com.iphone.telefone.AparelhoTelefonico;
import com.iphone.musica.ReprodutorMusical;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Iphone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{
    List <String> paginasEmCache = new ArrayList<>();
    List <String> listaDeMusicas = new ArrayList<>();
    List <String> contatosCadastrados = new ArrayList<>();

    public List<String> getContatosCadastrados() {
        return contatosCadastrados;
    }

    public void setContatosCadastrados(String contatoCadastrado) {
        if (!(contatosCadastrados.contains(contatoCadastrado))) {
            contatosCadastrados.add(contatoCadastrado);
        }
    }
    public List<String> getListaDeMusicas() {
        return listaDeMusicas;
    }
    
    public void setInListaDeMusicas(String musica) {
        if(!(listaDeMusicas.contains(musica))){
            listaDeMusicas.add(musica);
        }
    }
    
    public List<String> getPaginasEmCache() {
        return paginasEmCache;
    }

    public void setInPaginasEmCache(String paginaEmCache) {
        if(!(paginasEmCache.contains(paginaEmCache))){
            paginasEmCache.add(paginaEmCache);
        }
    }

    @Override
    public void pausar() {
        // TODO Auto-generated method stub
        try {
            System.out.println("Musica pausada!");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean selecionarMusica(String musica) {
        try {
            for (String musicaVerified : listaDeMusicas){
                if (musicaVerified.equalsIgnoreCase(musica)){
                    System.out.println("Musica '" + musica + "' selecionada");
                    return true;
                }
            } 
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void tocar() {
        // TODO Auto-generated method stub
        try {
            System.out.println("Musica tocando!");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public boolean atender() {
        // TODO Auto-generated method stub
        Random random = new Random();
        boolean atendido = false;
        int numeroEscolhido = random.nextInt(6);
        try{
            if (numeroEscolhido == 3){
                atendido = true; 
            }
        } catch(NumberFormatException e){
            e.printStackTrace();
        }
        return atendido;
    }

    @Override
    public void iniciarCorreioDeVoz() {
        int i = 0;
        try {
            if(contatosCadastrados.isEmpty()){
                System.out.println("Sem contatos cadastrados!");
                return;
            }
            
            System.out.println("Iniciando correio de voz com ".concat(contatosCadastrados.get(i)));
            i++;
        } catch (IndexOutOfBoundsException e ) {
            // TODO: handle exception
            System.out.println("Tamanho da lista excedido");
        }
    }

    @Override
    public void ligar(String numero) {
        // TODO Auto-generated method stub
        try {
            if (!(contatosCadastrados.contains(numero))) {
                setContatosCadastrados(numero);        
            }
            System.out.println("Ligando para (" + numero + ")" );
        } catch (NullPointerException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void adicionarAba() {
        // TODO Auto-generated method stub
        try {
            System.out.println("Adicionando pagina no navegador");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean atualizarPagina() {
        // TODO Auto-generated method stub
        Random random = new Random();
        int randomNumber = 0;
        try {
            do {
                System.out.println("Atualizando...\n");
                randomNumber = random.nextInt(5);
            } while (randomNumber != 2);
            
            return true;
        
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void exibirPagina(String url) {
        // TODO Auto-generated method stub
        try {
            if(!(paginasEmCache.contains(url))){
                setInPaginasEmCache(url);
            }
            System.out.println("Abrindo pagina em ".concat(url).concat("\n"));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
}
