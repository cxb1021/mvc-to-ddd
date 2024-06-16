package org.lv.application.employee.command;

import org.lv.common.framework.Command;
import org.lv.domain.WorkExperience;

public class AddWorkExperienceCommand implements Command {
    private String id;
    private WorkExperience workExperience;
}
