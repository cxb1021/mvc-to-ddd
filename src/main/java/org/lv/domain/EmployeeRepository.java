package org.lv.domain;

import java.util.List;

public interface EmployeeRepository {
    Employee findById(String id);
    Employee findByName(String name);

    Employee save(Employee employee);

    List<Employee> findAll();
}
