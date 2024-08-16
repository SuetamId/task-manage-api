package com.br.taskmanage.taskmanage_api.model.enums;

import lombok.Getter;

@Getter
public enum TaskStatus {
    TODO("TODO"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE");

    private final String taskStatus;

    TaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
