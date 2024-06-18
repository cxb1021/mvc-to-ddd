package org.lv.domain;

import lombok.Builder;
import lombok.Getter;
import org.lv.common.framework.AggregateRoot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
public class Employee implements AggregateRoot {
    private String id;
    private String name;
    private List<WorkExperience> workExperiences;

    public Employee addExperience(WorkExperience updateWorkExperience) {
        if (Objects.isNull(workExperiences)) {
            workExperiences = new ArrayList<>();
            workExperiences.add(updateWorkExperience);
            return this;
        }

        if (workExperiences.stream().anyMatch(workExperience -> workExperience.overlap(updateWorkExperience))) {
            throw new RuntimeException("时间段不能重复");
        }
        workExperiences.add(updateWorkExperience);
        return this;
    }

    public Employee setId(String id) {
        this.id = id;
        return this;
    }
}
