package com.br.taskmanage.taskmanage_api.model.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
    ADMIN("admin"),
    USER("user");

    private final String role;

    UserRoleEnum(String role) {
        this.role = role;
    }
}
