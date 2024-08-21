package com.br.taskmanage.taskmanage_api.service;

import com.br.taskmanage.taskmanage_api.DTO.RegisterDTO;
import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.model.enums.UserRoleEnum;
import com.br.taskmanage.taskmanage_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findByExcludedFalse();
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
        newUser.setExcluded(false);
        newUser.setPassword(new BCryptPasswordEncoder().encode(registerDTO.password()));
        newUser.setCreateAt(LocalDateTime.now());

        return userRepository.save(newUser);
    }

    public User updateUser(Long id, RegisterDTO userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id " + id + " not found"));

        user.setUsername(userDto.username());
        user.setPassword(userDto.password());
        user.setEmail(userDto.email());
        user.setRole(userDto.role());
        user.setUpdateAt(LocalDateTime.now());

        return userRepository.save(user);
    }

    public User delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id " + id + " not found"));

        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setRole(user.getRole());
        user.setExcluded(true);
        user.setUpdateAt(LocalDateTime.now());

        return userRepository.save(user);
    }
}
