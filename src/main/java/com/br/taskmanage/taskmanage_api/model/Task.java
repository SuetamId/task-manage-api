package com.br.taskmanage.taskmanage_api.model;

import com.br.taskmanage.taskmanage_api.model.enums.TaskStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;
import org.hibernate.mapping.Join;

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

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
