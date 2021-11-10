package com.commerce.f1shop.controller;
import com.commerce.f1shop.db.UserRepository;
import com.commerce.f1shop.exeptions.DoesNotExistException;
import com.commerce.f1shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) throws IOException {
        User user = userRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(path = { "/{id}" })
    public User deleteUser(@PathVariable("id") long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new DoesNotExistException(id));
        userRepository.deleteById(id);
        return user;
    }
}