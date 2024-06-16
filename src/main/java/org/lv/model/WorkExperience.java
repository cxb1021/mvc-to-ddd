package org.lv.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class WorkExperience {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate start;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
