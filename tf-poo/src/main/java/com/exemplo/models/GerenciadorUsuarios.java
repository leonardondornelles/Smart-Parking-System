package com.exemplo.models;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuarios {

    public static List<Usuario> gerenciadorUsuario = new ArrayList<>();

    public static boolean contemNome(String nome){
        for(Usuario usuario : gerenciadorUsuario){
            if (usuario.getNome().equals(nome)) return true;
        }
        return false;
    }

    public static boolean contemPlaca(String placa){
        for (Usuario usuario : gerenciadorUsuario){
            if (usuario.getPlacas().contains(placa)) return true;
        }
        return false;
    }

    public static List<String> listaDeNomes(){
        List<String> lista = gerenciadorUsuario.stream().map(Usuario::getNome).toList();

        return lista;
    }

    public static List<String> listaDePlacas(){
        return gerenciadorUsuario.stream().flatMap(u -> u.getPlacas().stream()).toList();
    }

    public static Usuario acharUsuarioPorNome(String nome){
        return gerenciadorUsuario.stream().filter(u -> u.getNome().equals(nome)).findFirst().orElse(null);
    }
}
