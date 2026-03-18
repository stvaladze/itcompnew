package com.itcomp.generics;

import com.itcomp.model.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter<T extends Employee> {

    public List<T> filterByMinimumSalary(List<T> employees, double minSalary) {
        List<T> result = new ArrayList<>();

        for (T employee: employees) {
            if (employee.getSalary() >= minSalary) {
                result.add(employee);
            }
        }

        return result;
    }
}
