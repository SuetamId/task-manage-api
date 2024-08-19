package com.br.taskmanage.taskmanage_api.service;

import com.br.taskmanage.taskmanage_api.DTO.RegisterDTO;
import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public UserDetails findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User save(RegisterDTO registerDTO) throws Exception {
        if(this.findByUsername(registerDTO.username()) != null){
            throw new Exception("Usuario já cadastrado");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        LocalDateTime now = LocalDateTime.now();

        User newUser = new User();
        newUser.setUsername(registerDTO.username());
        newUser.setPassword(encryptedPassword);
        newUser.setCreateAt(now);
        newUser.setRole(registerDTO.role());

        userRepository.save(newUser);
        return newUser;
    }
}
