package com.ibm.course.entities.resources;

import com.ibm.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> ok(){
        User u = new User(1L, "carlos", "carlos@ibm.com", "123132", "12345");

        return ResponseEntity.ok().body(u);
    }

}
