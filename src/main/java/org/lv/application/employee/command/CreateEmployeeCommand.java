package org.lv.application.employee.command;

import lombok.Data;
import org.lv.common.framework.Command;
import org.lv.domain.Employee;
import org.lv.domain.WorkExperience;

import java.util.List;

@Data
public class CreateEmployeeCommand implements Command {
    private String name;
    private List<WorkExperience> workExperiences;

    public Employee toEmployee() {
        return Employee.builder()
                .name(name)
                .workExperiences(workExperiences)
                .build();
    }
}
