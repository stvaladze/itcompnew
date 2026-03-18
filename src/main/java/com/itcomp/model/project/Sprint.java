package com.itcomp.model.project;

import com.itcomp.enums.SprintStatus;

import java.util.ArrayList;
import java.util.List;

public class Sprint {

    private int number;
    private List<Task> tasks = new ArrayList<>();
    private SprintStatus status;

    public Sprint(int number, SprintStatus status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public SprintStatus getStatus() {
        return status;
    }

    public void setStatus(SprintStatus status) {
        this.status = status;
    }
}
