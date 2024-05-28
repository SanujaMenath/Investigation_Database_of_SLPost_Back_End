package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IIAssignmentDTO {
    @NotNull
    private String caseNo;
    private InvestigationRefDTO investigation;
    private InspectorRefDTO inspector;
    private String acquiredDate;
    private String submittedDate;
    private String reacquiredDate;
    private String resubmittedDate;

}

