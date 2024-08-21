package com.br.taskmanage.taskmanage_api.DTO;

import com.br.taskmanage.taskmanage_api.model.User;
import com.br.taskmanage.taskmanage_api.model.enums.TaskStatusEnum;

public record TaskDTO(String title, String description, TaskStatusEnum status, User user, Boolean excluded) {
}
