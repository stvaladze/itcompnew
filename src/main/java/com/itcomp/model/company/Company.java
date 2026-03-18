package com.itcomp.model.company;

import com.itcomp.exception.InvalidDepartmentException;
import com.itcomp.model.person.Client;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private String location;
    private List<Department> departments = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public Company() {

    }

    public Company(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        if (department != null) {
            departments.add(department);
        }
    }
}
