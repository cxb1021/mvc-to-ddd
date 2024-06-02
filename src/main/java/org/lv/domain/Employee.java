package org.lv.domain;

import lombok.Getter;
import org.lv.common.framework.AggregateRoot;
import org.lv.model.Address;
import org.lv.model.EmpStatus;

import java.time.LocalDateTime;

@Getter
public class Employee extends AggregateRoot {
    private String id;
    private String name;
    private EmpStatus status;
    private Address address;

    public Employee(String id, String name, EmpStatus status, Address address, LocalDateTime createdAt, LocalDateTime lastUpdatedAt) {
        super(createdAt, lastUpdatedAt);
        this.id = id;
        this.name = name;
        this.status = status;
        this.address = address;
    }
}
