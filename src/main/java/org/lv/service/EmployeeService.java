package org.lv.service;

import org.lv.model.dto.CreateEmployeeDto;
import org.lv.model.Employee;
import org.lv.model.dto.UpdateWorkExperience;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDto createEmployeeDto);

    Employee update(UpdateWorkExperience updateWorkExperience);

    List<Employee> findAll();
}
