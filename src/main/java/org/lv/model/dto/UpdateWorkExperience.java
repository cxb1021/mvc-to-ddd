package org.lv.model.dto;

import lombok.Data;
import org.lv.model.Address;
import org.lv.model.EmpStatus;

@Data
public class UpdateWorkExperience {
    private String id;
    private EmpStatus status;
    private Address address;
}
