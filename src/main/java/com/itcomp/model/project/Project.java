package com.itcomp.model.project;

import java.util.Objects;
import com.itcomp.model.employee.Employee;
import com.itcomp.model.person.Client;
import com.itcomp.model.employee.Manager;
import com.itcomp.generics.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;
    private String description;
    private Client client;
    private Manager manager;
    private List<Employee> team = new ArrayList<>();
    private LinkedList<Task> tasks = new LinkedList<>();
    private String testingType;

    public Project() {
    }

    public Project(String name, String description, Client client, String testingType) {
        this.name = name;
        this.description = description;
        this.client = client;
        this.testingType = testingType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Employee> getTeam() {
        return new ArrayList<>(team);
    }

    public void setTeam(List<Employee> team) {
        this.team = team;
    }

    public LinkedList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        if (task != null) {
            tasks.add(task);
        }
    }

    public String getTestingType() {
        return testingType;
    }

    public void setTestingType(String testingType) {
        this.testingType = testingType;
    }

    @Override
    public String toString() {
        return "Project{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}