package com.br.taskmanage.taskmanage_api.model;

import com.br.taskmanage.taskmanage_api.model.enums.TaskStatus;
import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
