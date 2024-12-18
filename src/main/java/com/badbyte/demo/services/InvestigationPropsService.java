package com.badbyte.demo.services;

import com.badbyte.demo.dto.InvestigationPropsDTO;
import com.badbyte.demo.entity.*;
import com.badbyte.demo.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestigationPropsService {

    private final InvestigationRepo investigationRepository;
    private final SuspectorRepo suspectorRepository;
    private final InterimReportRepo interimReportsRepository;
    private final FormalInquiryRepo formalInquiriesRepository;
    private final ChargeSheetRepo chargeSheetsRepository;

    public InvestigationPropsService(InvestigationRepo investigationRepository,
                                     SuspectorRepo suspectorRepository,
                                     InterimReportRepo interimReportsRepository,
                                     FormalInquiryRepo formalInquiriesRepository,
                                     ChargeSheetRepo chargeSheetsRepository) {
        this.investigationRepository = investigationRepository;
        this.suspectorRepository = suspectorRepository;
        this.interimReportsRepository = interimReportsRepository;
        this.formalInquiriesRepository = formalInquiriesRepository;
        this.chargeSheetsRepository = chargeSheetsRepository;
    }

    @Transactional
    public void processInvestigation(InvestigationPropsDTO investigationPropsDTO) {
        // Save main investigation details
        Investigations investigation = new Investigations();
        investigation.setFileId(investigationPropsDTO.getFileId());
        investigation.setIncident(investigationPropsDTO.getIncident());
        investigation.setIncidentDate(investigationPropsDTO.getIncidentDate());
        // Set other fields...

        investigationRepository.save(investigation);

        // Save suspector
        List<Suspectors> suspectors = investigationPropsDTO.getSuspectors().stream().map(dto -> {
            Suspectors suspector = new Suspectors();
            suspector.setNic(dto.getNic());
            suspector.setName(dto.getName());
            suspector.setDob(dto.getDob());
            suspector.setRetiredDate(dto.getRetiredDate() != null ? dto.getRetiredDate() : null);
            return suspector;
        }).collect(Collectors.toList());
        suspectorRepository.saveAll(suspectors);

        // Save interim reports
        List<InterimReports> interimReports = investigationPropsDTO.getInterimReports().stream().map(dto -> {
            InterimReports interimReport = new InterimReports();
            interimReport.setInterimReportId(dto.getInterimReportId());
            interimReport.setInterimRecommendation(dto.getInterimRecommendation());
            interimReport.setDateIssued(dto.getDateIssued());
            interimReport.setInvestigations(investigation);
            return interimReport;
        }).collect(Collectors.toList());
        interimReportsRepository.saveAll(interimReports);

        // Save formal inquiries
        List<FormalInquiries> formalInquiries = investigationPropsDTO.getFormalInquiries().stream().map(dto -> {
            FormalInquiries formalInquiry = new FormalInquiries();
            formalInquiry.setId(dto.getId());
            formalInquiry.setDateOfAppoint((dto.getDateOfAppoint()));
            formalInquiry.setStartedDate(dto.getStartedDate());
            formalInquiry.setEndDate((dto.getEndDate()));
            formalInquiry.setRecommendationOfIO(dto.getRecommendationOfIO());
            formalInquiry.setDateOfRecommendation((dto.getDateOfRecommendation()));
            formalInquiry.setInvestigations(investigation);
            return formalInquiry;
        }).collect(Collectors.toList());
        formalInquiriesRepository.saveAll(formalInquiries);

        // Save charge sheets
        List<ChargeSheets> chargeSheets = investigationPropsDTO.getChargeSheets().stream().map(dto -> {
            ChargeSheets chargeSheet = new ChargeSheets();
            chargeSheet.setId(dto.getId());
            chargeSheet.setIssuedDate((dto.getIssuedDate()));
            chargeSheet.setDateOfAnswered((dto.getDateOfAnswered()));
            chargeSheet.setDisciplinaryOrder(dto.getDisciplinaryOrder());
            chargeSheet.setInvestigations(investigation);
            return chargeSheet;
        }).collect(Collectors.toList());
        chargeSheetsRepository.saveAll(chargeSheets);

        // investigation inspectors...
    }
}
