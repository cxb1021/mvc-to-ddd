package org.lv.common.framework;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AggregateRoot {
    protected LocalDateTime createdAt;
    protected LocalDateTime lastUpdatedAt;
}
