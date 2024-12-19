package com.badbyte.demo.services;

import com.badbyte.demo.entity.FormalInquiries;
import com.badbyte.demo.dto.FormalInquiryDTO;
import com.badbyte.demo.repository.FormalInquiryRepo;
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

    public List<FormalInquiries> getAllFormalInquiry() {
        return formalInquiryRepository.findAll();
    }

    public FormalInquiries getFormalInquiryById(Long id) {
        return formalInquiryRepository.findById(id).orElse(null);

    }

    public FormalInquiries saveFormalInquiry(FormalInquiryDTO formalInquiryDTO) {
        FormalInquiries inquiry = modelMapper.map(formalInquiryDTO, FormalInquiries.class);
        return formalInquiryRepository.save(inquiry);
    }
}