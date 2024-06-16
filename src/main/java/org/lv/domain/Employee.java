package org.lv.domain;

import lombok.Builder;
import lombok.Getter;
import org.lv.common.framework.AggregateRoot;
import org.lv.model.Address;
import org.lv.model.EmpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
public class Employee implements AggregateRoot {
    private String id;
    private String name;
    private List<WorkExperience> workExperiences;

    public Employee addExperience(WorkExperience updateWorkExperience) {
        if (workExperiences.stream().anyMatch(workExperience -> workExperience.overlap(updateWorkExperience))) {
            throw new RuntimeException("时间段不能重复");
        }
        workExperiences.add(updateWorkExperience);
        return this;
    }

    public void bindUserName(String newName, Employee existemployee){
        if (Objects.equals(newName, existemployee.getName())) {
            throw new RuntimeException("名称重复");
        }
        this.name = newName;
    }

    public Employee setId(String id) {
        this.id = id;
        return this;
    }
}
