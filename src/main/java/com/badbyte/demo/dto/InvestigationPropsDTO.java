package com.badbyte.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestigationPropsDTO {

    @NotNull
    private Long id;

    @NotNull
    private String fileId;

    @NotNull
    private String incident;

    @NotNull
    private LocalDateTime incidentDate;
    private LocalDateTime dateReferredToInvestigate;
    private LocalDateTime dateOfFinalReportIssued;
    private String recommendationOfFinalReport;
    private String personWhoAcceptedSubmission;
    private LocalDateTime acceptedSubmissionDate;
    private LocalDateTime handOveredDateOfSubmission;
    private int divisionId;
    private String status;

    private List<SuspectorDTO> suspectors;
    private List<InterimReportDTO> interimReports;
    private List<FormalInquiryDTO> formalInquiries;
    private List<ChargeSheetDTO> chargeSheets;
    private List<Investigation_Investigation_InspectorsDTO> investigationInspectors;

    private String appealedAcceptedOrRejected;
    private LocalDateTime dateOfRestateForAppealed;
    private LocalDateTime dateOfFinalOrderThatInformedToAccused;
    private LocalDateTime dateOfAppealedForReinstate;
}
