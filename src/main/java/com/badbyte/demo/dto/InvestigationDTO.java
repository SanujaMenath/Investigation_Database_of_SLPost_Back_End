package com.badbyte.demo.dto;

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
    private String fileId;

    @NotNull
    private String incident;

    @NotNull
    private LocalDateTime incidentDate;

    @NotNull
    private LocalDateTime dateReferredToInvestigate;

    private LocalDateTime dateOfFinalReportIssued;

    private String recommendationOfFinalReport;

    private String personWhoAcceptedSubmission;

    private LocalDateTime acceptedSubmissionDate;

    private LocalDateTime handOveredDateOfSubmission;

    private boolean status;
}
