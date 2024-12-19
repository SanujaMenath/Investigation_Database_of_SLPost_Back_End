package com.badbyte.demo.services;

import com.badbyte.demo.entity.Suspectors;
import com.badbyte.demo.dto.SuspectorDTO;
import com.badbyte.demo.repository.SuspectorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuspectorService {

    @Autowired
    private SuspectorRepo suspectorRepo;

    @Autowired
    ModelMapper modelMapper;

    public Suspectors getSuspectorById(Long id) {
        return suspectorRepo.findById(id).orElse(null);

    }

    public List<Suspectors> getAllSuspectors() {
        return suspectorRepo.findAll();
    }

    public Suspectors saveSuspector(SuspectorDTO suspectorDTO) {
        LocalDateTime retiredDate = CalculateRetirementDate(suspectorDTO.getDob(),60) ;

        suspectorDTO.setRetiredDate(retiredDate);

        Suspectors sus = modelMapper.map(suspectorDTO, Suspectors.class);


        return suspectorRepo.save(sus);
    }
    private LocalDateTime CalculateRetirementDate(LocalDateTime dob,int yearsToAdd) {
        return dob.plusYears(yearsToAdd);
    }




}