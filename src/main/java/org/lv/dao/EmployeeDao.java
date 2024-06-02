package org.lv.dao;

import org.lv.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void insert(Employee employee);

    Employee selectByName(String name);

    List<Employee> selectAll();
}
