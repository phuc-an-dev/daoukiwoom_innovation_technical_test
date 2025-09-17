package com.example.daoukiwoom_innovation_technical_test.event.listener;

import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import com.example.daoukiwoom_innovation_technical_test.event.TaskAssignedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaskAssignedListener {
    @EventListener
    public void handleTaskAssigned(TaskAssignedEvent event) {
        Task task = event.getTask();
        String assigneeId = task.getEmployee().getId();
        String assignedBy = task.getAssignedBy();
        log.info("Task '{}' has been assigned to employee {} by {}", task.getTaskName(), assigneeId, assignedBy);
    }
}
