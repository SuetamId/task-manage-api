package com.br.taskmanage.taskmanage_api.model.enums;

import lombok.Getter;

@Getter
public enum TaskStatusEnum {
    TODO("TODO"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE"),
    CANCELLED("CANCELLED");

    private final String taskStatus;

    TaskStatusEnum(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
