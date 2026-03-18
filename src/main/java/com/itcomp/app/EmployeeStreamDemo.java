package com.itcomp.app;

import com.itcomp.model.employee.Employee;

import java.util.List;

public class EmployeeStreamDemo {

    public static void processEmployees(List<Employee> employees) {

        employees.stream()

                .filter(e -> e.getSalary() >= Employee.MIN_SALARY)

                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))

                .map(e -> "Employee: " + e.getName() +
                        " | Salary: " + e.getSalary() +
                        " | Role: " + e.getAccess())

                .forEach(System.out::println);
    }
}