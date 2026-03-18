package com.itcomp.model.employee;

import com.itcomp.interfaces.Manageable;

public class Manager extends Employee implements Manageable {

    private int yearsOfExperience;
    private String role;


    public Manager(String name, String email, String phone, String country, String city, int id, double salary, int yearsOfExperience, String role) {
        super(name, email, phone, country, city, id, salary);
        this.yearsOfExperience = yearsOfExperience;
        this.role = role;
    }

    @Override
    public void work() {
        System.out.println("Manager plans, coordinates, and oversees the team");
    }

    @Override
    public void manage() {
        System.out.println("Manager manages the team");
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}