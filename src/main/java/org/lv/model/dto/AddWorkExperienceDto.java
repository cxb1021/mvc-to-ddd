package org.lv.model.dto;

import lombok.Data;
import org.lv.model.WorkExperience;

@Data
public class AddWorkExperienceDto {
    private String id;
    private WorkExperience workExperience;
}
