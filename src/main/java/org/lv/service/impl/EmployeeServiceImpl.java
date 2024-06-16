package org.lv.service.impl;

import cn.hutool.core.util.StrUtil;
import org.lv.dao.EmployeeDao;
import org.lv.model.Employee;
import org.lv.model.dto.CreateEmployeeDto;
import org.lv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee create(CreateEmployeeDto createEmployeeDto) {
        String name = createEmployeeDto.getName();

        if (StrUtil.isEmpty(name)) {
            throw new RuntimeException("名称不能为空");
        }

        Employee employee = employeeDao.selectByName(name);
        if (employee != null) {
            throw new RuntimeException("用户已存在");
        }

        Employee newEmployee = new Employee();
        newEmployee.setName(name);

        employeeDao.insert(newEmployee);
        return employeeDao.selectByName(name);
    }

    @Override
    public Employee update(UpdateEmployeeDto updateEmployeeDto) {
        String id = updateEmployeeDto.getId();
        EmpStatus status = updateEmployeeDto.getStatus();
        Address address = updateEmployeeDto.getAddress();

        if (!Arrays.asList(EmpStatus.PROBATION, EmpStatus.REGULAR, EmpStatus.TERMINATED).contains(status)) {
            throw new ServiceResException("状态不对");
        }
        if (Objects.nonNull(address) && !address.getProvince().equals("四川")) {
            throw new ServiceResException("只能是四川的");
        }

        if (Objects.isNull(employeeDao.selectById(id))) {
            throw new ServiceResException("用户不存在");
        }

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(id);
        updatedEmployee.setAddress(address);
        updatedEmployee.setStatus(status);

        return employeeDao.save(updatedEmployee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.selectAll();
    }
}
