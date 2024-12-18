package com.badbyte.demo.controller;

import com.badbyte.demo.dto.InvestigationPropsDTO;
import com.badbyte.demo.services.InvestigationPropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        investigationPropsService.processInvestigation(investigationPropsDTO);
        return ResponseEntity.ok("Investigation data processed successfully!");
    }
}
