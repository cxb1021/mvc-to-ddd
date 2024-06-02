package org.lv.dao.impl;

import org.lv.dao.EmployeeDao;
import org.lv.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final List<Employee> employeeList = new ArrayList<>();

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
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeList;
    }

    @Override
    public Employee save(Employee updatedDmployee) {
        employeeList.forEach(employee -> {
            if (employee.getId().equals(updatedDmployee.getId())) {
                if (Objects.nonNull(updatedDmployee.getAddress())) {
                    employee.setAddress(updatedDmployee.getAddress());
                }
                if (Objects.nonNull(updatedDmployee.getStatus())) {
                    employee.setStatus(updatedDmployee.getStatus());
                }
            }
        });

        return selectById(updatedDmployee.getId());
    }
}
