package com.br.taskmanage.taskmanage_api.service;

import ch.qos.logback.core.util.StringUtil;
import com.br.taskmanage.taskmanage_api.DTO.RegisterDTO;
import com.br.taskmanage.taskmanage_api.DTO.TaskDTO;
import com.br.taskmanage.taskmanage_api.infra.security.TokenService;
import com.br.taskmanage.taskmanage_api.model.Task;
import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.model.enums.TaskStatusEnum;
import com.br.taskmanage.taskmanage_api.repository.TaskRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findByExcludedFalse();
    }

    public Task save(Task task){
        if(StringUtils.isEmpty(task.getTitle()) && StringUtils.isEmpty(task.getDescription())){
            System.out.println("Titulo e descrição não podem estar vazios");
        }

        var user = authorizationService.getCurrentUser();
        if (user == null) {
            throw new RuntimeException("User not authenticated");
        }

        task.setStatus(TaskStatusEnum.TODO);
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        task.setCreateAt(LocalDateTime.now());
        task.setExcluded(false);
        task.setUser((User) user);

        return taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskDTO taskDTO) throws Exception {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task with id " + id + " not found"));

        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setStatus(taskDTO.status());
        task.setUser(taskDTO.user());
        task.setExcluded(false);
        task.setUpdateAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    public Task delete(Long id) throws Exception {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new Exception("Task with id " + id + " not found"));

        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        task.setStatus(task.getStatus());
        task.setUser(task.getUser());
        task.setUpdateAt(LocalDateTime.now());
        task.setExcluded(true);

        return taskRepository.save(task);
    }

}
