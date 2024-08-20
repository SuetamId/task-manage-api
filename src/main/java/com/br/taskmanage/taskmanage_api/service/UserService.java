package com.br.taskmanage.taskmanage_api.service;

import com.br.taskmanage.taskmanage_api.DTO.RegisterDTO;
import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.model.enums.UserRoleEnum;
import com.br.taskmanage.taskmanage_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
            throw new Exception("User already registered");
        }

        User newUser = new User();

        newUser.setUsername(registerDTO.username());
        if(registerDTO.email() != null){
            newUser.setEmail(registerDTO.email());
        }
        newUser.setRole(UserRoleEnum.USER);
        newUser.setPassword(new BCryptPasswordEncoder().encode(registerDTO.password()));
        newUser.setCreateAt(LocalDateTime.now());
        newUser.setRole(registerDTO.role());

        return userRepository.save(newUser);
    }
}
