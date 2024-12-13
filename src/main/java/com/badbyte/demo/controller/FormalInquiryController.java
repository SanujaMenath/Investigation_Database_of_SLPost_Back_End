package com.badbyte.demo.controller;

import com.badbyte.demo.entity.FormalInquiries;
import com.badbyte.demo.entity.Investigations;
import com.badbyte.demo.dto.FormalInquiryDTO;
import com.badbyte.demo.services.FormalInquiryService;
import com.badbyte.demo.services.InvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formal-inquiries")
@CrossOrigin(origins = "http://localhost:8080")
public class FormalInquiryController {

    @Autowired
    private FormalInquiryService formalInquiryService;
    @Autowired
    private InvestigationService investigationService;

    @GetMapping
    public List<FormalInquiries> getAllFormalInquiries() {
            return formalInquiryService.getAllFormalInquiry();
    }

    @GetMapping("/{id}")
    public FormalInquiries getFormalInquiryById(@PathVariable String id) {
        return formalInquiryService.getFormalInquiryById(id);
    }
    @PostMapping
    public ResponseEntity<Object> createInspector(@RequestBody FormalInquiryDTO inquiryDTO) {

        Investigations investigations = investigationService.getInvestigationByFileNumber(inquiryDTO.getInvestigation().getFileId());

        if (investigations == null){
            return ResponseEntity.badRequest().body("Investigation is not found in the db.");
        }

        FormalInquiries inquiry = formalInquiryService.saveFormalInquiry(inquiryDTO);

        return ResponseEntity.ok(inquiry);
    }
}
