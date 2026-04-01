package com.itcomp.app;

import com.itcomp.model.employee.Employee;
import com.itcomp.logger.AppLogger;

import java.util.List;
import java.util.logging.Logger;

public class EmployeeStreamDemo {

    private static final Logger logger =
            AppLogger.getLogger(EmployeeStreamDemo.class);

    public static void processEmployees(List<Employee> employees) {

        employees.stream()

                .filter(e -> e.getSalary() >= Employee.MIN_SALARY)

                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))

                .map(e -> "Employee: " + e.getName() +
                        " | Salary: " + e.getSalary() +
                        " | Role: " + e.getAccess())

                .forEach(logger::info);
    }
}