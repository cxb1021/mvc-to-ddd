package org.lv.dao.impl;

import org.lv.dao.EmployeeDao;
import org.lv.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public void insert(Employee employee) {
        employee.setId(String.valueOf(employeeList.size()));
        employeeList.add(employee);
    }

    @Override
    public Employee selectById(String id) {
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Employee selectByName(String name) {
        return employeeList.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeList;
    }
}
