package com.br.taskmanage.taskmanage_api.controller;

import com.br.taskmanage.taskmanage_api.DTO.RegisterDTO;
import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> findAll(){
      return ResponseEntity.ok(userService.findAll());
  }

  @Secured({"ADMIN"})
  @PostMapping
  public ResponseEntity<User> save(@RequestBody RegisterDTO user) throws Exception {
    return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
  }

  @Secured({"ADMIN"})
  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable Long id, @RequestBody RegisterDTO user) throws Exception {
      return ResponseEntity.ok(userService.updateUser(id, user));
  }

  @Secured({"ADMIN"})
  @PutMapping("delete/{id}")
  public ResponseEntity<User> delete(@PathVariable Long id) throws Exception {
    return ResponseEntity.ok(userService.delete(id));
  }
}
