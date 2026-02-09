package org.example.users.controller;

import org.example.users.entity.User;
import org.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")

public class UserController {
    @Autowired
    private UserService userService;

    // 1er leer (GET)
    @GetMapping
    public List<User> getAll() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getById(@PathVariable("userId") Long userId) {
        return userService.getUser(userId);
    }

    // Crear o actualizar (POST)
    @PostMapping
    public User saveUpdate(@RequestBody User user){
        userService.saveOrUpdate(user);
        return user;
    }

    // 4. ACTUALIZAR (PUT)
    @PutMapping("/{userId}")
    public User update(@PathVariable("userId") Long userId, @RequestBody User user) {
        // Forzamos el ID del usuario con el que viene en la URL
        // Así JPA sabe que tiene que sobreescribir esa fila, no crear una nueva.
        user.setId(userId);
        userService.saveOrUpdate(user);
        return user;
    }


    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId")Long userId){
        userService.delete(userId);
    }
}
