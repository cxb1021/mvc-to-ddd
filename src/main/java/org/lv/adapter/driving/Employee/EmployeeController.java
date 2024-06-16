package org.lv.adapter.driving.Employee;

import org.lv.model.Employee;
import org.lv.model.dto.CreateEmployeeDto;
import org.lv.model.dto.UpdateWorkExperience;
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

    @PutMapping()
    public Employee update(@RequestBody UpdateWorkExperience updateWorkExperience) {
        return employeeService.update(updateWorkExperience);
    }

    @GetMapping("/all")
    public List<Employee> queryAll() {
        return employeeService.findAll();
    }
}
