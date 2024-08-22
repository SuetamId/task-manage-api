package com.br.taskmanage.taskmanage_api.model;

import com.br.taskmanage.taskmanage_api.model.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private TaskStatusEnum status;

    @Column(name = "bo_excluded")
    private Boolean excluded;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "createAt")
    private LocalDateTime createAt;

    @Column(name = "updateAt")
    private LocalDateTime updateAt;
}
