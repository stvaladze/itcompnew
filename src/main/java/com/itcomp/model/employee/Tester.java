package com.itcomp.model.employee;

import com.itcomp.interfaces.Testable;

public class Tester extends Employee implements Testable {

    private String testingType;
    private String tool;


    public Tester(String name, String email, String phone, String country, String city, int id, double salary, String testingType, String tool) {
        super(name, email, phone, country, city, id, salary);
        this.testingType = testingType;
        this.tool = tool;
    }

    @Override
    public void work() {
        System.out.println("Employee.Tester tests features");
    }

    @Override
    public void test() {
        System.out.println("Testing application");
    }

    public String getTestingType() {
        return testingType;
    }

    public void setTestingType(String testingType) {
        this.testingType = testingType;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }
}