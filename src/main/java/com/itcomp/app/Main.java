package com.itcomp.app;

import com.itcomp.logger.AppLogger;
import com.itcomp.model.employee.Employee;
import com.itcomp.model.employee.Developer;
import com.itcomp.model.employee.Tester;
import com.itcomp.enums.AccessRole;
import com.itcomp.pool.ConnectionPool;
import com.itcomp.pool.AppConnection;
import com.itcomp.parser.WordCounter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger =
            AppLogger.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            WordCounter.count("input.txt", "output.csv");
        } catch (Exception e) {
            logger.warning("WordCounter error: " + e.getMessage());
        }

        List<Employee> employees = new CopyOnWriteArrayList<>();

        employees.add(new Developer(
                "John", "Doe", "IT", "Germany", "Berlin",
                1, 5000.0
        ));

        employees.add(new Tester(
                "Anna", "Smith", "QA", "Germany", "Berlin",
                2, 4000.0, "Automation", "Selenium"
        ));

        logger.info("=== Employees ===");

        employees.forEach(e ->
                logger.info(e.getName() + " | " + e.getSalary())
        );


        ConnectionPool pool = ConnectionPool.getInstance();
        AppConnection connection = null;

        try {
            connection = pool.getConnection();
            logger.info("Connection acquired: " + connection.getId());
        } catch (Exception e) {
            logger.severe("Connection error: " + e.getMessage());
        } finally {
            if (connection != null) {
                pool.releaseConnection(connection);
                logger.info("Connection released");
            }
        }

        AccessRole role = AccessRole.ADMIN;
        logger.info("Role: " + role);
    }
}