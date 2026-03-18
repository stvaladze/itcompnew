package com.itcomp.model.company;

import com.itcomp.model.employee.Employee;
import com.itcomp.model.employee.Manager;
import com.itcomp.exception.InvalidDepartmentException;
import com.itcomp.logger.AppLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Department {

    private static final Logger logger = AppLogger.getLogger(Department.class);

    private String name;
    private Manager manager;
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String name, Manager manager) {
        setName(name);
        setManager(manager);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            return;
        }

        employees.add(employee);
    }

    public void addEmployee(Employee employee, boolean printInfo) {
        if (employee != null) {
            employees.add(employee);

            if (printInfo) {
               logger.info(employee.getName() + " added to department " + name);
            }
        }
    }
}