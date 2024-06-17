package org.lv.application.employee.query;

import org.lv.domain.Employee;
import org.lv.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeQueryApplicationService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
