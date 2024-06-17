package org.lv.adapter.driver.Employee;

import org.lv.domain.Employee;
import org.lv.domain.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee findById(String id) {
        return employeeList.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Employee findByName(String name) {
        return employeeList.stream().filter(employee -> employee.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        employee.setId(String.valueOf(employeeList.size()));
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }
}
