package org.lv.service;

import org.lv.model.dto.CreateEmployeeDto;
import org.lv.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDto createEmployeeDto);

    List<Employee> findAll();
}
