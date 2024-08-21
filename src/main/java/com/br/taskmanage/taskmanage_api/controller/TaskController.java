package com.br.taskmanage.taskmanage_api.controller;

import com.br.taskmanage.taskmanage_api.DTO.RegisterDTO;
import com.br.taskmanage.taskmanage_api.DTO.TaskDTO;
import com.br.taskmanage.taskmanage_api.model.Task;
import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(task));
    }

    @Secured({"ADMIN"})
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody TaskDTO task) throws Exception {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @Secured({"ADMIN"})
    @PutMapping("delete/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(taskService.delete(id));
    }
}
