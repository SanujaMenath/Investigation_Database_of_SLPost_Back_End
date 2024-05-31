package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvestigationDTO {

    @NotNull
    @NotEmpty
    private String fileId;

    @NotNull
    @NotEmpty
    private String incident;

    @NotNull
    @NotEmpty
    private LocalDateTime incidentDate;

    private LocalDateTime dateReferredToInvestigate;

    private LocalDateTime dateOfFinalReportIssued;

    private String recommendationOfFinalReport;

    private String personWhoAcceptedSubmission;

    private LocalDateTime acceptedSubmissionDate;

    private LocalDateTime handOveredDateOfSubmission;

    private String status;
}
