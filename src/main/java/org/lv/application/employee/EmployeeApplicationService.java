package org.lv.application.employee;

import cn.hutool.core.util.StrUtil;
import org.lv.application.employee.command.CreateEmployeeCommand;
import org.lv.domain.Employee;
import org.lv.domain.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeApplicationService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee create(CreateEmployeeCommand command) {
        Employee employee = command.toEmployee();

        if (StrUtil.isEmpty(employee.getName())) {
            throw new RuntimeException("名称不能为空");
        }

        Employee existEmployee = employeeRepository.findByName(employee.getName())
        if (Objects.nonNull(existEmployee)) {
            throw new RuntimeException("用户已存在");
        }

        return employeeRepository.save(employee);
    }
}
