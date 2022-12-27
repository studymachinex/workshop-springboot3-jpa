package com.ibm.course.config;

import com.ibm.course.entities.Category;
import com.ibm.course.entities.Order;
import com.ibm.course.entities.User;
import com.ibm.course.entities.enums.OrderStatus;
import com.ibm.course.repositories.CategoryRepository;
import com.ibm.course.repositories.OrderRepository;
import com.ibm.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
@Configuration // Informa ao Spring que é o nosso perfil de configuracao
@Profile("test") // Perfil de teste
public class TestConfig implements CommandLineRunner {

    @Autowired //Resolve a dependencia e associa à instancia "UserRepository"
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override //tudo dentro desse metodo roda quando a aplicação é iniciada
    public void run(String... args) {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        
        User u1 = new User(null, "usuario1", "usuario1@gmail.com", "988888888", "123456");
        User u2 = new User(null, "usuario2", "usuario2@gmail.com", "977777777", "123456");
        // u1 = new User(null, "Maria Brown", "brown@gmail.com", "988888888", "123456");
        Order o1 = new Order(null, Instant.now(), OrderStatus.SHIPPED , u1);
        Order o2 = new Order(null, Instant.now(), OrderStatus.PAID , u2);
        Order o3 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        
    }
}