package com.badbyte.demo.services;

import com.badbyte.demo.dto.InvestigationPropsDTO;
import com.badbyte.demo.entity.*;
import com.badbyte.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;

@Service
public class InvestigationPropsService {

    private final InvestigationRepo investigationRepository;
    private final SuspectorRepo suspectorRepository;
    private final InterimReportRepo interimReportsRepository;
    private final FormalInquiryRepo formalInquiriesRepository;
    private final ChargeSheetRepo chargeSheetsRepository;
    private final InvInspectorRepo invInspectorRepository;

    public InvestigationPropsService(InvestigationRepo investigationRepository,
                                     SuspectorRepo suspectorRepository,
                                     InterimReportRepo interimReportsRepository,
                                     FormalInquiryRepo formalInquiriesRepository,
                                     InvInspectorRepo invInspectorRepository,
                                     ChargeSheetRepo chargeSheetsRepository) {
        this.investigationRepository = investigationRepository;
        this.suspectorRepository = suspectorRepository;
        this.interimReportsRepository = interimReportsRepository;
        this.formalInquiriesRepository = formalInquiriesRepository;
        this.chargeSheetsRepository = chargeSheetsRepository;
        this.invInspectorRepository = invInspectorRepository;
    }

    @Transactional
    public void processInvestigation(InvestigationPropsDTO investigationPropsDTO) {
        Investigations investigation = new Investigations();
        investigation.setFileId(investigationPropsDTO.getFileId());
        investigation.setIncident(investigationPropsDTO.getIncident());
        investigation.setIncidentDate(investigationPropsDTO.getIncidentDate());
        investigation.setDateReferredToInvestigate(investigationPropsDTO.getDateReferredToInvestigate());
        investigation.setDateOfFinalReportIssued(investigationPropsDTO.getDateOfFinalReportIssued());
        investigation.setRecommendationOfFinalReport(investigationPropsDTO.getRecommendationOfFinalReport());
        investigation.setPersonWhoAcceptedSubmission(investigationPropsDTO.getPersonWhoAcceptedSubmission());
        investigation.setAcceptedSubmissionDate(investigationPropsDTO.getAcceptedSubmissionDate());
        investigation.setHandOveredDateOfSubmission(investigationPropsDTO.getHandOveredDateOfSubmission());
        investigation.setDivisionId(investigationPropsDTO.getDivisionId());
        investigation.setStatus(investigationPropsDTO.getStatus());
        investigationRepository.save(investigation);

        // Save suspector
        List<Suspectors> suspectors = investigationPropsDTO.getSuspectors() != null
                ? investigationPropsDTO.getSuspectors().stream().map(dto -> {
            Suspectors suspector = new Suspectors();
            suspector.setNic(dto.getNic());
            suspector.setName(dto.getName());
            suspector.setDob(dto.getDob());
            return suspector;
        }).collect(Collectors.toList())
                : Collections.emptyList();
        suspectorRepository.saveAll(suspectors);

        // Save interim reports
        List<InterimReports> interimReports = investigationPropsDTO.getInterimReports() != null
                ? investigationPropsDTO.getInterimReports().stream().map(dto -> {
            InterimReports interimReport = new InterimReports();
            interimReport.setInterimReportId(dto.getInterimReportId());
            interimReport.setInterimRecommendation(dto.getInterimRecommendation());
            Investigation_Inspectors investigator = invInspectorRepository.findByNic(dto.getInvestigationInspector().getNic())
                    .orElseThrow(() -> new RuntimeException("Investigator with NIC " + dto.getInvestigationInspector().getNic() + " not found"));
            interimReport.setDateIssued(dto.getDateIssued());
            interimReport.setInvestigations(investigation);
            return interimReport;
        }).collect(Collectors.toList())
                : Collections.emptyList();
        interimReportsRepository.saveAll(interimReports);

        // Save formal inquiries
        List<FormalInquiries> formalInquiries = investigationPropsDTO.getFormalInquiries() != null
                ? investigationPropsDTO.getFormalInquiries().stream().map(dto -> {
            FormalInquiries formalInquiry = new FormalInquiries();
            formalInquiry.setDateOfAppoint(dto.getDateOfAppoint());
            formalInquiry.setStartedDate(dto.getStartedDate());
            formalInquiry.setEndDate(dto.getEndDate());
            formalInquiry.setRecommendationOfIO(dto.getRecommendationOfIO());
            formalInquiry.setDateOfRecommendation(dto.getDateOfRecommendation());
            formalInquiry.setInvestigations(investigation);
            return formalInquiry;
        }).collect(Collectors.toList())
                : Collections.emptyList();
        formalInquiriesRepository.saveAll(formalInquiries);

        // Save charge sheets
        List<ChargeSheets> chargeSheets = investigationPropsDTO.getChargeSheets() != null
                ? investigationPropsDTO.getChargeSheets().stream().map(dto -> {
            ChargeSheets chargeSheet = new ChargeSheets();
            chargeSheet.setIssuedDate(dto.getIssuedDate());
            chargeSheet.setDateOfAnswered(dto.getDateOfAnswered());
            chargeSheet.setDisciplinaryOrder(dto.getDisciplinaryOrder());
            chargeSheet.setInvestigations(investigation);
            return chargeSheet;
        }).collect(Collectors.toList())
                : Collections.emptyList();
        chargeSheetsRepository.saveAll(chargeSheets);
    }
}
