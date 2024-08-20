package com.br.taskmanage.taskmanage_api.service;

import ch.qos.logback.core.util.StringUtil;
import com.br.taskmanage.taskmanage_api.infra.security.TokenService;
import com.br.taskmanage.taskmanage_api.model.Task;
import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.model.enums.TaskStatusEnum;
import com.br.taskmanage.taskmanage_api.repository.TaskRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        return taskRepository.findAll();
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
        task.setUser((User) user);

        return taskRepository.save(task);
    }
}
