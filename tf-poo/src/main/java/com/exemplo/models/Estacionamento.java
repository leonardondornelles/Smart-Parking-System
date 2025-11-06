package com.exemplo.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estacionamento {
    private List<Usuario> usuariosCadastrados;
    private Map<String, Usuario> mapaDePlacas;
    private List<Acesso> historicoDeAcessosConcluidos;
    private Map<String, Acesso> carrosEstacionados;

    public Estacionamento(){
        this.usuariosCadastrados = new ArrayList<>();
        this.mapaDePlacas = new HashMap<>();
        this.historicoDeAcessosConcluidos = new ArrayList<>();
        this.carrosEstacionados = new HashMap<>();
    }

    public void cadastrarUsuario(Usuario novoUsuario){
        this.usuariosCadastrados.add(novoUsuario);
    }

    public void registrarEntrada(String placa){
        if(carrosEstacionados.size() <= 500 && mapaDePlacas.containsKey(placa) && !carrosEstacionados.containsKey(placa)){

            return;
        }
        System.out.println("Erro: Estacionamento está lotado");
    }

    public boolean registrarVeiculoUsuario(Usuario usuario, String placa){
        if(mapaDePlacas.containsKey(placa)){
            System.out.println("Erro: A placa: " + placa + " já foi registrada");
            return false;
        }

        boolean sucesso = usuario.registrarVeiculo(placa);

        if(sucesso){
            this.mapaDePlacas.put(placa, usuario);
            System.out.println("Veículo: " + placa + " registrado com sucesso para " + usuario.getNome());
            return true;
        } else {
            System.out.println("Erro: Usuário " + usuario.getNome() + " atingiu o limite de veículos");
            return false;
        }
    }

    public Usuario encontrarDonoDaPlaca(String placa){
        return this.mapaDePlacas.get(placa);
    }

    public String listarUsuarios(){
        if (usuariosCadastrados.isEmpty()) {
            return "Não há usuários cadastrados.";
        }

        StringBuilder sb = new StringBuilder();
        System.out.println("\n=== Lista de Usuários ===\n");

        for(Usuario u : usuariosCadastrados){
            sb.append("\n--------------\n");
            sb.append("Nome: ").append(u.getNome()).append("\n");
            sb.append("Placas: ").append(u.getPlacas()).append("\n");
            sb.append("--------------\n");
        }

        return sb.toString();
    }
}