package org.example.users.service;

import org.example.users.entity.User;
import org.example.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //obtener todos
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    //Obtener por id
    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

    //guardar o actualizar
    public void saveOrUpdate(User user){
        userRepository.save(user);
    }

    //Eliminar
    public void delete(Long id){
        userRepository.deleteById(id);
    }


}
