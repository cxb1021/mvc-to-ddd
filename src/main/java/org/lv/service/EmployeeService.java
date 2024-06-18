package org.lv.service;

import org.lv.model.dto.CreateEmployeeDto;
import org.lv.model.Employee;
import org.lv.model.dto.UpdateEmployeeDto;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDto createEmployeeDto);

    Employee addWorkExperience(UpdateEmployeeDto updateEmployeeDto);

    List<Employee> findAll();
}
