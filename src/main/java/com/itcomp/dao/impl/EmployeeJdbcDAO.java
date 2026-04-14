package com.itcomp.dao.impl;

import com.itcomp.dao.AbstractJdbcDAO;
import com.itcomp.dao.EmployeeDAO;
import com.itcomp.mapper.EmployeeRowMapper;
import com.itcomp.model.employee.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeJdbcDAO extends AbstractJdbcDAO<Employee, Integer>
        implements EmployeeDAO {

    public EmployeeJdbcDAO(Connection connection) {
        super(connection, new EmployeeRowMapper());
    }

    @Override
    protected String getTableName() {
        return "employees";
    }

    @Override
    protected String getIdColumn() {
        return "id";
    }

    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employees(name, salary) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setDouble(2, employee.getSalary());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employees SET name = ?, salary = ? WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setDouble(2, employee.getSalary());
            ps.setInt(3, employee.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Employee> findByName(String name) {
        String sql = "SELECT * FROM employees WHERE name = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Optional.of(mapper.map(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(double salary) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE salary > ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDouble(1, salary);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapper.map(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE department = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, department);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapper.map(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}