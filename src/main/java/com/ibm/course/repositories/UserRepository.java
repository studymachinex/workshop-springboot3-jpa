package com.ibm.course.repositories;
import com.ibm.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Camada de repositorios da aplicação (Acesso ao banco de dados utilizando o JPARepository)

@Repository // indica que é o nosso repositorio
public interface UserRepository extends JpaRepository<User, Long> {

}