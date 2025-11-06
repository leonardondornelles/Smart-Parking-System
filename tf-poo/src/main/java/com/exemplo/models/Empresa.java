package com.exemplo.models;

public class Empresa extends Usuario{

    public Empresa(String nome, String placa) {
        super(nome, placa);
    }

    @Override
    public boolean registrarVeiculo(String placa) {
        if (super.getPlacas().contains(placa)) return false;
        super.getPlacas().add(placa);
        return true;
    }

    @Override
    public double calculaValorEstacionamento(Acesso acesso) {
        return 0;
    }
}
