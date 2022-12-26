package com.ibm.course.config;

import com.ibm.course.entities.User;
import com.ibm.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
@Configuration // Informa ao Spring que é o nosso perfil de configuracao
@Profile("test") // Perfil de teste
public class TestConfig implements CommandLineRunner {
    @Autowired //Resolve a dependencia e associa à instancia "UserRepository"
    private UserRepository userRepository;

    @Override //tudo dentro desse metodo roda quando a aplicação é iniciada
    public void run(String... args) {

        User u1 = new User(null, "usuario1", "usuario1@gmail.com", "988888888", "123456");
        User u2 = new User(null, "usuario2", "usuario2@gmail.com", "977777777", "123456");
        // u1 = new User(null, "Maria Brown", "brown@gmail.com", "988888888", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}