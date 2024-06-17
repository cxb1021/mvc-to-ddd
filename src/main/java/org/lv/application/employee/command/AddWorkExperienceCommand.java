package org.lv.application.employee.command;

import lombok.Data;
import org.lv.common.framework.Command;
import org.lv.domain.WorkExperience;

@Data
public class AddWorkExperienceCommand implements Command {
    private String id;
    private WorkExperience workExperience;
}
