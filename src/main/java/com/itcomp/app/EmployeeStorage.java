package com.itcomp.app;

import com.itcomp.model.employee.Employee;
import com.itcomp.model.employee.Developer;
import com.itcomp.model.employee.Tester;
import com.itcomp.enums.AccessRole;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EmployeeStorage {

    private final List<Employee> employees = new CopyOnWriteArrayList<>();

    public EmployeeStorage() {

        Employee e1 = new Developer("John", "john@mail.com", "123", "USA", "NY", 1, 3000);
        e1.setAccess(AccessRole.DEVELOPER);

        Employee e2 = new Tester("Anna","anna@mail.com","459", "USA", "LA", 2, 4000, "Manual", "TestRail");
        e2.setAccess(AccessRole.TESTER);

        employees.add(e1);
        employees.add(e2);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}