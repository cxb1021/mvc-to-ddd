package org.lv.model.dto;

import lombok.Data;
import org.lv.model.Address;
import org.lv.model.EmpStatus;

@Data
public class CreateEmployeeDto {
    private String name;
    private EmpStatus status;
    private Address address;
}
