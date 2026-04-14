package com.itcomp.app;

import com.itcomp.dao.EmployeeDAO;
import com.itcomp.dao.impl.EmployeeJdbcDAO;
import com.itcomp.logger.AppLogger;
import com.itcomp.model.employee.Developer;
import com.itcomp.model.employee.Employee;
import com.itcomp.pool.ConnectionPool;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger =
            AppLogger.getLogger(Main.class);

    public static void main(String[] args) {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;

        try {

            connection = pool.getConnection();


            EmployeeDAO dao = new EmployeeJdbcDAO(connection);

            logger.info("=== TEST DAO START ===");


            Employee dev = new Developer(
                    "Mike", "Ross", "IT", "USA", "NY",
                    3, 7000.0
            );

            dao.save(dev);
            logger.info("Saved employee: " + dev.getName());


            List<Employee> employees = dao.findAll();
            logger.info("=== ALL EMPLOYEES ===");
            employees.forEach(e ->
                    logger.info(e.getId() + " | " + e.getName() + " | " + e.getSalary())
            );


            Optional<Employee> found = dao.findById(1);
            found.ifPresent(e ->
                    logger.info("Found by ID: " + e.getName())
            );


            Optional<Employee> byName = dao.findByName("Mike");
            byName.ifPresent(e ->
                    logger.info("Found by name: " + e.getName())
            );


            List<Employee> richEmployees = dao.findBySalaryGreaterThan(4500);
            logger.info("=== HIGH SALARY EMPLOYEES ===");
            richEmployees.forEach(e ->
                    logger.info(e.getName() + " | " + e.getSalary())
            );


            if (found.isPresent()) {
                Employee e = found.get();
                e.setSalary(9999.0);
                dao.update(e);
                logger.info("Updated salary for: " + e.getName());
            }


            dao.delete(3);
            logger.info("Deleted employee with ID 3");

            logger.info("=== TEST DAO END ===");

        } catch (Exception e) {
            logger.severe("Error: " + e.getMessage());
        } finally {

            if (connection != null) {
                pool.releaseConnection(connection);
            }
        }
    }
}