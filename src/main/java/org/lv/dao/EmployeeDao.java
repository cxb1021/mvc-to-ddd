package org.lv.dao;

import org.lv.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public void insert(Employee employee);

    public Employee selectById(String id);

    public Employee selectByName(String name);

    public List<Employee> selectAll();
}
