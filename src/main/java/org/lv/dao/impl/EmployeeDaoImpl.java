package org.lv.dao.impl;

import org.lv.dao.EmployeeDao;
import org.lv.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private List<Employee> employeeList = new ArrayList<>();

    @Override
    public void insert(Employee employee) {
        employee.setId(String.valueOf(employeeList.size()));
        employeeList.add(employee);
    }

    @Override
    public Employee selectByName(String name) {
        return employeeList.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Employee selectById(String id) {
        Employee foundEmployee = employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
        if (Objects.nonNull(foundEmployee) && Objects.isNull(foundEmployee.getWorkExperiences())) {
            foundEmployee.setWorkExperiences(new ArrayList<>());
        }
        return foundEmployee;
    }

    @Override
    public List<Employee> selectAll() {
        return employeeList;
    }

    @Override
    public Employee save(Employee updatedDemployee) {
        employeeList = employeeList.stream().map(employee -> employee.getId().equals(updatedDemployee.getId()) ? updatedDemployee : employee).toList();
        return selectById(updatedDemployee.getId());
    }
}
