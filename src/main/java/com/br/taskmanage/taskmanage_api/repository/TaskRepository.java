package com.br.taskmanage.taskmanage_api.repository;

import com.br.taskmanage.taskmanage_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByExcludedFalse();
    List<Task> findByExcludedFalseAndUserId(Long id);

}
