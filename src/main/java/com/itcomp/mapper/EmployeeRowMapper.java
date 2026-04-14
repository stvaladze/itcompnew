package com.itcomp.mapper;

import com.itcomp.model.employee.Employee;
import com.itcomp.model.employee.Developer;
import com.itcomp.model.employee.Tester;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee map(ResultSet rs) throws SQLException {

        String type = rs.getString("type");

        int id = rs.getInt("id");
        String name = rs.getString("name");
        double salary = rs.getDouble("salary");

        if ("DEVELOPER".equalsIgnoreCase(type)) {
            return new Developer(
                    name, "", "", "", "", // adjust based on your constructor
                    id,
                    salary
            );
        }

        if ("TESTER".equalsIgnoreCase(type)) {
            return new Tester(
                    name, "", "", "", "",
                    id,
                    salary,
                    "manual", "default" // adjust if needed
            );
        }

        throw new RuntimeException("Unknown employee type: " + type);
    }
}