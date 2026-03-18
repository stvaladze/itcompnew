package com.itcomp.generics;

import java.util.ArrayList;
import java.util.List;
import com.itcomp.model.employee.Employee;

public class EmployeeRepository<T extends Employee> {
    private final List<T> employees = new ArrayList<>();

    public void add(T employee) {
        employees.add(employee);
    }

    public List<T> getAll() {
        return new ArrayList<>(employees);
    }

    public int size() {
        return employees.size();
    }
}
