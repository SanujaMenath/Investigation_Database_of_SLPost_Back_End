package com.badbyte.demo.services;

import com.badbyte.demo.Entity.Suspector;
import com.badbyte.demo.dto.SuspectorDTO;
import com.badbyte.demo.repository.SuspectRepo;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuspectorService {

    @Autowired
    private SuspectRepo suspectRepo;

    @Autowired
    ModelMapper modelMapper;

    public Suspector getSuspectorById(String nic) {
        return suspectRepo.findById(nic).orElse(null);

    }

    public List<Suspector> getAllSuspectors() {
        return suspectRepo.findAll();
    }

    public Suspector saveSuspector(SuspectorDTO suspectorDTO) {
        LocalDateTime retiredDate = CalculateRetirementDate(suspectorDTO.getDob(),60) ;

        suspectorDTO.setRetiredDate(retiredDate);

        Suspector sus = modelMapper.map(suspectorDTO, Suspector.class);


        return suspectRepo.save(sus);
    }
    private LocalDateTime CalculateRetirementDate(LocalDateTime dob,int yearsToAdd) {
        return dob.plusYears(yearsToAdd);
    }


}