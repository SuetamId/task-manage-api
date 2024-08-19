package com.br.taskmanage.taskmanage_api.controller;

import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
