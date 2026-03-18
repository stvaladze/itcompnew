package com.itcomp.model.employee;

import com.itcomp.exception.InvalidEmployeeDataException;
import com.itcomp.interfaces.Workable;
import com.itcomp.model.person.Person;
import com.itcomp.enums.AccessRole;

public abstract class Employee extends Person implements Workable {

    private final int id;
    private double salary;
    public static final int MIN_SALARY = 1000;
    public static final int MAX_SALARY = 20000;
    private AccessRole access;


    public Employee(String name, String email, String phone, String country, String city, int id, double salary) {

        super(name, email, phone, country, city);

        this.id = id;
        this.salary = salary;
    }

    public abstract void work();

    public final int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public AccessRole getAccess() {
        return access;
    }

    public void setAccess(AccessRole access) {
        this.access = access;
    }




    @Override
    public String toString() {
        return "Employee{id=" + id +
                ", name='" + getName() +
                "', salary=" + salary +
                ", role=" + access +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {

        return Integer.hashCode(id);
    }
}