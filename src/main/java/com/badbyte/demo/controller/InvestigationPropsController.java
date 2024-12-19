package com.badbyte.demo.controller;

import com.badbyte.demo.dto.InvestigationPropsDTO;
import com.badbyte.demo.services.InvestigationPropsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/investigationform")
@CrossOrigin(origins = "http://localhost:8080")
public class InvestigationPropsController {

    private final InvestigationPropsService investigationPropsService;

    public InvestigationPropsController(InvestigationPropsService investigationPropsService) {
        this.investigationPropsService = investigationPropsService;
    }

    @PostMapping("create")
    public ResponseEntity<String> createInvestigation(@RequestBody InvestigationPropsDTO investigationPropsDTO) {
        try {
            investigationPropsService.processInvestigation(investigationPropsDTO);
            return ResponseEntity.ok("Investigation data processed successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing investigation data: " + e.getMessage());
        }
    }
}
