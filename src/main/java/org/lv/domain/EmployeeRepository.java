package org.lv.domain;

public interface EmployeeRepository {
    Employee findById(String id);
    Employee findByName(String name);

    Employee save(Employee employee);
}
