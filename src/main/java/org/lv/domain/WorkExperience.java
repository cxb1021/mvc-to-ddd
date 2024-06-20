package org.lv.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.lv.common.framework.ValueObject;

import java.time.LocalDate;

public class WorkExperience implements ValueObject {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    public boolean overlap(WorkExperience workExperience) {
        if (workExperience == null) {
            throw new IllegalArgumentException("入参不能为空！");
        }
        return workExperience.start.isBefore(end) && workExperience.end.isAfter(start);
    }
}
