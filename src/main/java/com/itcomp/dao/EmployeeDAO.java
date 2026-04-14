package com.itcomp.dao;

import com.itcomp.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO extends BaseDAO<Employee, Integer> {

    Optional<Employee> findByName(String name);

    List<Employee> findBySalaryGreaterThan(double salary);

    List<Employee> findByDepartment(String department);
}
