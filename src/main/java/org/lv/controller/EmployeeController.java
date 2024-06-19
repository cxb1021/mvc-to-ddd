package org.lv.controller;

import org.lv.model.Employee;
import org.lv.model.dto.AddWorkExperienceDto;
import org.lv.model.dto.CreateEmployeeDto;
import org.lv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto) {
        return employeeService.create(createEmployeeDto);
    }

    @PutMapping("/addWorkExperience")
    public Employee addWorkExperience(@RequestBody AddWorkExperienceDto addWorkExperienceDto) {
        return employeeService.addWorkExperience(addWorkExperienceDto);
    }

    @GetMapping("/all")
    public List<Employee> queryAll() {
        return employeeService.findAll();
    }
}
