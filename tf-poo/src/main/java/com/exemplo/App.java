package com.exemplo;

import com.exemplo.models.Estudante;
import com.exemplo.models.GerenciadorUsuarios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        GerenciadorUsuarios.gerenciadorUsuario.add(new Estudante("Nicolas", "AA"));
        GerenciadorUsuarios.gerenciadorUsuario.add(new Estudante("Dornelles", "BB"));
        SpringApplication.run(App.class, args);
    }
}
