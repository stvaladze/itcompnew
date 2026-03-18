package com.itcomp.model.person;

import com.itcomp.interfaces.Billable;
import com.itcomp.model.project.Project;
import com.itcomp.enums.ContractType;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Billable {

    private double budget;
    private ContractType contractType;
    private boolean active;
    private List<Project> projects = new ArrayList<>();

    public Client() {

        super();
        setBudget(budget);
        setContractType(contractType);
        this.active = true;
    }

    public Client(String name, String email, String phone, String country, String city, double budget,ContractType contractType) {
        super(name, email, phone, country, city);
        this.budget = budget;
        this.active = true;
    }

    @Override
    public double getBudget(){
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
