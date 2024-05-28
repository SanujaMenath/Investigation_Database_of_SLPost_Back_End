package com.badbyte.demo.services;

import com.badbyte.demo.Entity.InterimReport;
import com.badbyte.demo.dto.InterimReportDTO;
import com.badbyte.demo.repository.InterimReportRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterimReportService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    InterimReportRepo interimReportRepository;

    public List<InterimReport> getAllInterimReports() {
        return interimReportRepository.findAll();
    }

    public InterimReport getInterimReportById(String interimReportId) {
        return interimReportRepository.findById(interimReportId).orElse(null);
    }

    public InterimReport saveInterimReport(InterimReportDTO interimReport) {
        InterimReport intReport = modelMapper.map(interimReport, InterimReport.class);
        return interimReportRepository.save(intReport);
    }

}
