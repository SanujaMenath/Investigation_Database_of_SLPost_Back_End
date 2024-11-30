package com.badbyte.demo.services;

import com.badbyte.demo.Entity.InterimReports;
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

    public List<InterimReports> getAllInterimReports() {
        return interimReportRepository.findAll();
    }

    public InterimReports getInterimReportById(String interimReportId) {
        return interimReportRepository.findById(interimReportId).orElse(null);
    }

    public InterimReports saveInterimReport(InterimReportDTO interimReport) {
        InterimReports intReport = modelMapper.map(interimReport, InterimReports.class);
        return interimReportRepository.save(intReport);
    }

}
