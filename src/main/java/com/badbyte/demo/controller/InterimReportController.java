package com.badbyte.demo.controller;

import com.badbyte.demo.entity.InterimReports;
import com.badbyte.demo.entity.Investigations;
import com.badbyte.demo.entity.Investigation_Inspectors;
import com.badbyte.demo.dto.InterimReportDTO;
import com.badbyte.demo.services.InterimReportService;
import com.badbyte.demo.services.InvInspectorService;
import com.badbyte.demo.services.InvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interim-report")
@CrossOrigin(origins = "http://localhost:8080")
public class InterimReportController {

    @Autowired
    private InterimReportService interimReportService;
    @Autowired
    private InvestigationService investigationService;

    @Autowired
    private InvInspectorService invInspectorService;

    @GetMapping
    public List <InterimReports> getAllReports() {
        return interimReportService.getAllInterimReports();
    }

    @GetMapping("/{id}")
    public InterimReports getReportById(@PathVariable String id) {
        return interimReportService.getInterimReportById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addReport(@RequestBody InterimReportDTO interimReport) {
        Investigations investigations = investigationService.getInvestigationByFileNumber(interimReport.getInvestigation().getFileId());
        Investigation_Inspectors inspector = invInspectorService.getInspectorById(interimReport.getInvestigationInspector().getNic());

        if (investigations == null){
            return ResponseEntity.badRequest().body("Investigation is not found in the db.");
        }

        if (inspector == null){
            return ResponseEntity.badRequest().body("Inspector is not found in the db.");
        }

        InterimReports report = interimReportService.saveInterimReport(interimReport);

        return ResponseEntity.ok(report);
    }

}
