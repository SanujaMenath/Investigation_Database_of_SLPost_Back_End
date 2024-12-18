package com.badbyte.demo.dto;

import com.badbyte.demo.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvestigationPropsDTO {

    private String fileId;
    private String incident;
    private Date incidentDate;
    private Date dateReferredToInvestigate;
    private Date dateOfFinalReportIssued;
    private String recommendationOfFinalReport;
    private String personWhoAcceptedSubmission;
    private String acceptedSubmissionDate;
    private Date handOveredDateOfSubmission;
    private int divisionId;
    private String status;

    private List<SuspectorDTO> suspectors;
    private List<InterimReportDTO> interimReports;
    private List<FormalInquiryDTO> formalInquiries;
    private List<ChargeSheetDTO> chargeSheets;
    private List<Investigation_Investigation_InspectorsDTO> investigationInspectors;

    private String appealedAcceptedOrRejected;
    private Date dateOfRestateForAppealed;
    private Date dateOfFinalOrderThatInformedToAccused;
    private Date dateOfAppealedForReinstate;
}
