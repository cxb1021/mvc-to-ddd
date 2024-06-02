package org.lv.service.impl;

import cn.hutool.core.util.StrUtil;
import org.lv.dao.EmployeeDao;
import org.lv.model.dto.CreateEmployeeDto;
import org.lv.exception.ServiceResException;
import org.lv.model.Address;
import org.lv.model.EmpStatus;
import org.lv.model.Employee;
import org.lv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee create(CreateEmployeeDto createEmployeeDto) {
        String name = createEmployeeDto.getName();
        EmpStatus status = createEmployeeDto.getStatus();
        Address address = createEmployeeDto.getAddress();
        if (StrUtil.isEmpty(name)) {
            throw new ServiceResException("名称不能为空");
        }
        if (!Arrays.asList(EmpStatus.PROBATION, EmpStatus.REGULAR, EmpStatus.TERMINATED).contains(status)) {
            throw new ServiceResException("状态不对");
        }
        Employee employee = employeeDao.selectByName(name);
        if (employee != null) {
            throw new ServiceResException("用户已存在");
        }

        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        newEmployee.setStatus(status);
        newEmployee.setAddress(address);

        employeeDao.insert(newEmployee);
        return employeeDao.selectByName(name);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.selectAll();
    }
}
