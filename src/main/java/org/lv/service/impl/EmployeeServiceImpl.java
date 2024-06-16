package org.lv.service.impl;

import cn.hutool.core.util.StrUtil;
import org.lv.dao.EmployeeDao;
import org.lv.model.dto.CreateEmployeeDto;
import org.lv.exception.ServiceResException;
import org.lv.model.Address;
import org.lv.model.EmpStatus;
import org.lv.model.Employee;
import org.lv.model.dto.UpdateWorkExperience;
import org.lv.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        if (!address.getProvince().equals("四川")) {
            throw new ServiceResException("只能是四川的");
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
    public Employee update(UpdateWorkExperience updateWorkExperience) {
        String id = updateWorkExperience.getId();
        EmpStatus status = updateWorkExperience.getStatus();
        Address address = updateWorkExperience.getAddress();

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
