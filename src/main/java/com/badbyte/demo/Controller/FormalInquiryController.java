package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.FormalInquiry;
import com.badbyte.demo.dto.FormalInquiryDTO;
import com.badbyte.demo.services.FormalInquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formal-inquiries")
public class FormalInquiryController {

    @Autowired
    private FormalInquiryService formalInquiryService;

    @GetMapping
    public List<FormalInquiry> getAllFormalInquiries() {
            return formalInquiryService.getAllFormalInquiry();
    }

    @GetMapping("/{id}")
    public FormalInquiry getFormalInquiryById(@PathVariable String id) {
        return formalInquiryService.getFormalInquiryById(id);
    }
    @PostMapping
    public FormalInquiry createInspector(@RequestBody FormalInquiryDTO inquiryDTO) {
        return formalInquiryService.saveFormalInquiry(inquiryDTO);
    }
}
