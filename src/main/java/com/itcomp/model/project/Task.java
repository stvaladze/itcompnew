package com.itcomp.model.project;

import com.itcomp.model.employee.Employee;
import com.itcomp.interfaces.Assignable;
import com.itcomp.enums.TaskStatus;
import com.itcomp.enums.TaskPriority;


public class Task implements Assignable {

    private String title;
    private String description;
    private TaskStatus status;
    private Employee assignee;
    private TaskPriority priority;

    public Task() {

        this.status = TaskStatus.TODO;
    }

    public Task(String title, String description, Employee assignee, TaskPriority priority) {
        setTitle(title);
        setDescription(description);
        setAssignee(assignee);
        setPriority(priority);
        this.status = TaskStatus.TODO;
    }
 
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }
}
