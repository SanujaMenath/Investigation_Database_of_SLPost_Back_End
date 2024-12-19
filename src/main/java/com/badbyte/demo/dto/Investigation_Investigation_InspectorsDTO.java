package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Investigation_Investigation_InspectorsDTO {
    @NotNull
    private String caseNo;
    private InvestigationRefDTO investigation;
    private InspectorRefDTO inspector;
    private LocalDateTime acquiredDate;
    private LocalDateTime submittedDate;
    private LocalDateTime reacquiredDate;
    private LocalDateTime resubmittedDate;

}

