package com.br.taskmanage.taskmanage_api.DTO;

import com.br.taskmanage.taskmanage_api.model.enums.UserRoleEnum;

import java.time.LocalDateTime;

public record RegisterDTO(String username, String email, String password, UserRoleEnum role, LocalDateTime createAt, LocalDateTime updateAt) {
}
