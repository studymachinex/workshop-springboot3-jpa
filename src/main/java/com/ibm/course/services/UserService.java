package com.ibm.course.services;

import com.ibm.course.entities.User;
import com.ibm.course.repositories.UserRepository;
import com.ibm.course.services.exceptions.DataBaseException;
import com.ibm.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow( () -> new ResourceNotFoundException(id) ) ;
    }
    public User postUser(User user){
        return repository.save(user);
    }

    public void deleteUser(Long id){
        try{
            repository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }
    
    public User updateUser(Long id, User user){
        try{
            User entity = repository.getReferenceById(id);
            updateData(entity, user);
            return repository.save(entity);
        } 
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}