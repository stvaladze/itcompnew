package com.itcomp.generics;

import java.util.List;
import com.itcomp.model.employee.Employee;

public class PayrollService<T extends Employee> {

    public double calculateTotal(List<T> employees) {
        double total = 0;

        for (T employee : employees) {
            total += employee.getSalary();
        }

        return total;
    }

    public double calculateAverage(List<T> employees) {
        if (employees.isEmpty()) {
            return 0;

        }

        return calculateTotal(employees) /employees.size();
    }
}
