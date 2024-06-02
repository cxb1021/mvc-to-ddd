package org.lv.dao;

import org.lv.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void insert(Employee employee);

    Employee selectByName(String name);

    Employee selectById(String id);

    List<Employee> selectAll();

    Employee save(Employee employee);
}
