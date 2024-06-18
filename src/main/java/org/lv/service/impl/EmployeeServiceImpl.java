package org.lv.service.impl;

import cn.hutool.core.util.StrUtil;
import org.lv.dao.EmployeeDao;
import org.lv.model.Employee;
import org.lv.model.WorkExperience;
import org.lv.model.dto.AddWorkExperienceDto;
import org.lv.model.dto.CreateEmployeeDto;
import org.lv.model.dto.UpdateEmployeeDto;
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
    public Employee addWorkExperience(AddWorkExperienceDto addWorkExperience) {
        String id = updateEmployeeDto.getId();
        WorkExperience updatedWorkExperience = updateEmployeeDto.getWorkExperience();
        Employee employee = employeeDao.selectById(id);

        if (Objects.isNull(employee)) {
            throw new RuntimeException("用户不存在");
        }

        if (Objects.nonNull(updatedWorkExperience)) {
            employee.getWorkExperiences().forEach(workExperience -> {
                if (workExperience.overlap(updatedWorkExperience)) {
                    throw new RuntimeException("经验时间段不能重复");
                }
            });
        }
        employee.getWorkExperiences().add(updatedWorkExperience);

        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.selectAll();
    }
}
