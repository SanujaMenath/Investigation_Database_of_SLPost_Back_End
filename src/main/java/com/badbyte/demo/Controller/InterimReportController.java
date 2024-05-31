package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.InterimReport;
import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.Entity.InvestigationInspector;
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
public class InterimReportController {

    @Autowired
    private InterimReportService interimReportService;
    @Autowired
    private InvestigationService investigationService;

    @Autowired
    private InvInspectorService invInspectorService;

    @GetMapping
    public List <InterimReport> getAllReports() {
        return interimReportService.getAllInterimReports();
    }

    @GetMapping("/{id}")
    public InterimReport getReportById(@PathVariable String id) {
        return interimReportService.getInterimReportById(id);
    }

    @PostMapping
    public ResponseEntity<Object> addReport(@RequestBody InterimReportDTO interimReport) {
        Investigation investigation = investigationService.getInvestigationByFileNumber(interimReport.getInvestigation().getFileId());
        InvestigationInspector inspector = invInspectorService.getInspectorById(interimReport.getInvestigationInspector().getNic());

        if (investigation == null){
            return ResponseEntity.badRequest().body("Investigation is not found in the db.");
        }

        if (inspector == null){
            return ResponseEntity.badRequest().body("Inspector is not found in the db.");
        }

        InterimReport report = interimReportService.saveInterimReport(interimReport);

        return ResponseEntity.ok(report);
    }

}
