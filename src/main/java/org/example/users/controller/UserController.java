package org.example.users.controller;

import org.example.users.entity.User;
import org.example.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

//nuevos agregados para validaciones de http
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/users")

public class UserController {
    @Autowired
    private UserService userService;

    // 1er leer (GET) -> ResponseEntity retornar 200 ok
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getUsers());
    }

    // 2. Buscar por id (GET) ->retorna 200 ok o 404 NOT FOUND
    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable("userId") Long userId)
    {
        Optional<User> user = userService.getUser(userId);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get()); // Econtrado 200
        }
        else {
            return ResponseEntity.notFound().build(); //No encontrado 404
        }
        //return userService.getUser(userId);/// sin ResponseEntity
    }

    // 3. Crear o actualizar (POST)
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        userService.saveOrUpdate(user);
        //Devolvemos código 201 (creado) en lugar de 200
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // 4. ACTUALIZAR (PUT)
    @PutMapping("/{userId}")
    public ResponseEntity<User> update(@PathVariable("userId") Long userId, @RequestBody User user) {
        Optional<User> userExistente = userService.getUser(userId);

        if (userExistente.isPresent()){
            user.setId(userId);
            userService.saveOrUpdate(user);
            return ResponseEntity.ok(user); //200 ok usuario actualizado
        }
        else{
            return ResponseEntity.notFound().build();//404 si intentar editar a userId que no exista
        }
        // Forzamos el ID del usuario con el que viene en la URL
        // Así JPA sabe que tiene que sobreescribir esa fila, no crear una nueva.

    }

    //5. ELIMINAR (DELETE) -> retorna 204 NO CONTENT (Exito pero sin cuerpo)
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId")Long userId){
        Optional<User> user= userService.getUser(userId);
        if (user.isPresent()){
            userService.delete(userId);
            return ResponseEntity.noContent().build();//204  "lo borré sin nada de cuerpo"
        }else{
            return ResponseEntity.notFound().build(); //404 ... no puedo borrar lo que no exite
        }
        //userService.delete(userId);
    }
}
