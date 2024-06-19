package org.lv.service;

import org.lv.model.dto.AddWorkExperienceDto;
import org.lv.model.dto.CreateEmployeeDto;
import org.lv.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee create(CreateEmployeeDto createEmployeeDto);

    Employee addWorkExperience(AddWorkExperienceDto addWorkExperienceDto);

    List<Employee> findAll();
}
