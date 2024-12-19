package com.badbyte.demo.services;



import com.badbyte.demo.entity.Investigations;
import com.badbyte.demo.dto.InvestigationDTO;
import com.badbyte.demo.repository.InvestigationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestigationService {
    @Autowired
    private InvestigationRepo repository;

    @Autowired
    ModelMapper modelMapper;

    public List<Investigations> getAllInvestigations() {
        return repository.findAll();
    }

    public Investigations getInvestigationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Investigations saveInvestigation(InvestigationDTO investigation) {
        Investigations inv = modelMapper.map(investigation, Investigations.class);

        return repository.save(inv);
    }

    public Investigations editInvestigation(Long id, InvestigationDTO investigationToUpdate) {
        Investigations alreadyExistingInvestigations = getInvestigationById(id);

        modelMapper.map(investigationToUpdate, alreadyExistingInvestigations);

        return repository.save(alreadyExistingInvestigations);
    }



    public void deleteInvestigation(Long id) {
        repository.deleteById(id);
    }

    public List<Investigations> searchInvestigations(String keyword) {

        List<Investigations> investigations = repository.searchInvestigations(keyword);
        if (investigations.isEmpty()) {
            throw new IllegalArgumentException("No investigations found for the keyword: " + keyword);
        }

        return investigations;
    }

}
