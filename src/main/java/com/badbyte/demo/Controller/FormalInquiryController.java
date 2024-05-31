package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.FormalInquiry;
import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.dto.FormalInquiryDTO;
import com.badbyte.demo.services.FormalInquiryService;
import com.badbyte.demo.services.InvestigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/formal-inquiries")
public class FormalInquiryController {

    @Autowired
    private FormalInquiryService formalInquiryService;
    @Autowired
    private InvestigationService investigationService;

    @GetMapping
    public List<FormalInquiry> getAllFormalInquiries() {
            return formalInquiryService.getAllFormalInquiry();
    }

    @GetMapping("/{id}")
    public FormalInquiry getFormalInquiryById(@PathVariable String id) {
        return formalInquiryService.getFormalInquiryById(id);
    }
    @PostMapping
    public ResponseEntity<Object> createInspector(@RequestBody FormalInquiryDTO inquiryDTO) {

        Investigation investigation = investigationService.getInvestigationByFileNumber(inquiryDTO.getInvestigation().getFileId());

        if (investigation == null){
            return ResponseEntity.badRequest().body("Investigation is not found in the db.");
        }

        FormalInquiry inquiry = formalInquiryService.saveFormalInquiry(inquiryDTO);

        return ResponseEntity.ok(inquiry);
    }
}
