package com.badbyte.demo.services;



import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.dto.InvestigationDTO;
import com.badbyte.demo.repository.InvestiRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationService {
    @Autowired
    private InvestiRepo repository;

    @Autowired
    ModelMapper modelMapper;

    public List<Investigation> getAllInvestigations() {
        return repository.findAll();
    }

    public Investigation getInvestigationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Investigation saveInvestigation(InvestigationDTO investigation) {
        Investigation inv = modelMapper.map(investigation, Investigation.class);

        return repository.save(inv);
    }

    public Investigation editInvestigation(Long id, InvestigationDTO investigationToUpdate) {
        Investigation alreadyExistingInvestigation = getInvestigationById(id);

        modelMapper.map(investigationToUpdate, alreadyExistingInvestigation);

        return repository.save(alreadyExistingInvestigation);
    }

    public Investigation tgetInvestigationByFileNumber(String fileNumber) {
        return repository.findByFileNumber(fileNumber);
    }

    public void deleteInvestigation(Long id) {
        repository.deleteById(id);
    }
}
