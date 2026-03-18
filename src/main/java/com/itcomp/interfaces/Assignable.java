package com.itcomp.interfaces;

import com.itcomp.model.employee.Employee;

public interface Assignable {
    void setAssignee (Employee employee);
    Employee getAssignee();
}
