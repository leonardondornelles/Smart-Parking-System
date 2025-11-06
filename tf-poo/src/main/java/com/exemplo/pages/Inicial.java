package com.exemplo.pages;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("inicial")
public class Inicial extends VerticalLayout {

    public Inicial() {
        add(
                new RouterLink("Cadastrar usuário",CadastrarUsuario.class),
                new RouterLink("Entrar com veículo", Entrada.class),
                new RouterLink("Sair com veículo", Saida.class),
                new RouterLink("Efetuar pagamento", Pagamento.class),
                new RouterLink("Ver informações", Informacao.class),
                new RouterLink("Editar placa", EditarPlaca.class)
        );
    }
}
