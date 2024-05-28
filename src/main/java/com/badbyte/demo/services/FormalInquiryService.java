package com.badbyte.demo.services;

import com.badbyte.demo.Entity.FormalInquiry;
import com.badbyte.demo.dto.FormalInquiryDTO;
import com.badbyte.demo.repository.FormalInquiryRepo;
import jakarta.persistence.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormalInquiryService {
    @Autowired
    private FormalInquiryRepo formalInquiryRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<FormalInquiry> getAllFormalInquiry() {
        return formalInquiryRepository.findAll();
    }

    public FormalInquiry getFormalInquiryById(String id) {
        return formalInquiryRepository.findById(id).orElse(null);

    }

    public FormalInquiry saveFormalInquiry(FormalInquiryDTO formalInquiryDTO) {
        FormalInquiry inquiry = modelMapper.map(formalInquiryDTO, FormalInquiry.class);
        return formalInquiryRepository.save(inquiry);
    }
}