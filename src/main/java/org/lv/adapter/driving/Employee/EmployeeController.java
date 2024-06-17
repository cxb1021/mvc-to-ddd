package org.lv.adapter.driving.Employee;

import org.lv.application.employee.command.EmployeeApplicationService;
import org.lv.application.employee.command.AddWorkExperienceCommand;
import org.lv.application.employee.command.CreateEmployeeCommand;
import org.lv.application.employee.query.EmployeeQueryApplicationService;
import org.lv.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeApplicationService employeeApplicationService;

    @Autowired
    private EmployeeQueryApplicationService employeeQueryApplicationService;

    @PostMapping
    public Employee createEmployee(@RequestBody CreateEmployeeCommand createEmployeeCommand) {
        return employeeApplicationService.create(createEmployeeCommand);
    }

    @PutMapping()
    public Employee update(@RequestBody AddWorkExperienceCommand addWorkExperienceCommand) {
        return employeeApplicationService.addWorkExperience(addWorkExperienceCommand);
    }

    @GetMapping("/all")
    public List<Employee> queryAll() {
        return employeeQueryApplicationService.findAll();
    }
}
