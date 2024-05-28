package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.InterimReport;
import com.badbyte.demo.dto.InterimReportDTO;
import com.badbyte.demo.services.InterimReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interim-report")
public class InterimReportController {

    @Autowired
    private InterimReportService interimReportService;

    @GetMapping
    public List <InterimReport> getAllReports() {
        return interimReportService.getAllInterimReports();
    }

    @GetMapping("/{id}")
    public InterimReport getReportById(@PathVariable String id) {
        return interimReportService.getInterimReportById(id);
    }

    @PostMapping
    public InterimReport addReport(@RequestBody InterimReportDTO interimReport) {
        return interimReportService.saveInterimReport(interimReport);
    }

}
