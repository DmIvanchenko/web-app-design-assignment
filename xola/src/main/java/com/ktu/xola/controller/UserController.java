package com.ktu.xola.controller;

import com.ktu.xola.exception.EmailAlreadyInUseException;
import com.ktu.xola.model.User;
import com.ktu.xola.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RequiredArgsConstructor
@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok().body(userService.findAllUsers());
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUserById(@PathVariable int id){
        return ResponseEntity.ok().body(userService.findUserById(id));
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws EmailAlreadyInUseException {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").toUriString());
        return ResponseEntity.created(uri).body(this.userService.createUser(user));

    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User user ){
        user.setId(id);
        return ResponseEntity.ok().body(this.userService.updateUser(user));

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        this.userService.deleteUser(id);
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
    }


}
