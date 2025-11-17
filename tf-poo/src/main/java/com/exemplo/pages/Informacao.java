package com.exemplo.pages;

import com.exemplo.models.*;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.format.DateTimeFormatter;

@Route("informacao")
public class Informacao extends VerticalLayout {
    Grid<Acesso> gridEstacionado;
    Grid<Acesso> gridRetirados;
    ComboBox<String> comboEmpresa;
    private Button voltar;
    Text text;
    H1 h1Estacionado;
    H1 h1Retirado;

    public Informacao(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        text = new Text("");
        h1Estacionado = new H1("Carros Estacionados");
        h1Retirado = new H1("Carros Retirados");
        gridEstacionado = new Grid<>(Acesso.class, false);
        gridEstacionado.setItems(Estacionamento.carrosEstacionados.values());
        gridEstacionado.addColumn(Acesso::getNome).setHeader("Usuário");
        gridEstacionado.addColumn(Acesso::getPlaca).setHeader("Placa");
        gridEstacionado.addColumn(a -> a.getDataEntrada().format(formatter)).setHeader("Hora de Entrada");



        gridRetirados = new Grid<>(Acesso.class, false);
        gridRetirados.setItems(Estacionamento.carrosAcessosConcluidos.values());
        gridRetirados.addColumn(Acesso::getNome).setHeader("Usuário");
        gridRetirados.addColumn(Acesso::getPlaca).setHeader("Placa");
        gridRetirados.addColumn(a -> a.getDataEntrada().format(formatter)).setHeader("Hora de Entrada");
        gridRetirados.addColumn(a -> a.getDataSaida().format(formatter)).setHeader("Hora de Saída");




        comboEmpresa = new ComboBox<>("Empresa");
        comboEmpresa.setItems(GerenciadorUsuarios.listaDeEmpresas());
        add(new H1("Valor Gasto pela Empresa: "), comboEmpresa);
        comboEmpresa.addValueChangeListener(e -> {
            Empresa empresa = (Empresa) GerenciadorUsuarios.acharUsuarioPorNome(comboEmpresa.getValue());
            text.setText("Valor: R$ " + empresa.getValorTotalMensal());
        });



        voltar = new Button("Voltar");
        voltar.addClickListener(e -> UI.getCurrent().navigate("inicial"));
        add(h1Estacionado, gridEstacionado, h1Retirado, gridRetirados, comboEmpresa, text, voltar);
    }
}
