package com.example.daoukiwoom_innovation_technical_test.event;

import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class TaskAssignedEvent extends ApplicationEvent {
    private final Task task;

    public TaskAssignedEvent(Object source, Task task) {
        super(source);
        this.task = task;
    }
}
