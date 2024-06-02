package org.lv.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.lv.common.framework.ValueObject;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address implements ValueObject {
    private String province;
    private String city;
}
