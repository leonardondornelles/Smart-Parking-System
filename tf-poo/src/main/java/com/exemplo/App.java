package com.exemplo;

import com.exemplo.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        GerenciadorUsuarios.gerenciadorUsuario.add(new Estudante("Nicolas", "AA"));
        GerenciadorUsuarios.gerenciadorUsuario.add(new Estudante("Dornelles", "BB"));
        GerenciadorUsuarios.gerenciadorUsuario.add(new Funcionario("Augustini", "CC"));
        GerenciadorUsuarios.gerenciadorUsuario.add(new Empresa("Dell", "DD"));
        Usuario dell = GerenciadorUsuarios.acharUsuarioPorNome("Dell");
        dell.registrarVeiculo("EE");

        SpringApplication.run(App.class, args);
    }
}
