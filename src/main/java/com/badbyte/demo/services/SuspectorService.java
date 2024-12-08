package com.badbyte.demo.services;

import com.badbyte.demo.entity.Suspectors;
import com.badbyte.demo.dto.SuspectorDTO;
import com.badbyte.demo.repository.SuspectRepo;
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

    public Suspectors getSuspectorById(String nic) {
        return suspectRepo.findById(nic).orElse(null);

    }

    public List<Suspectors> getAllSuspectors() {
        return suspectRepo.findAll();
    }

    public Suspectors saveSuspector(SuspectorDTO suspectorDTO) {
        LocalDateTime retiredDate = CalculateRetirementDate(suspectorDTO.getDob(),60) ;

        suspectorDTO.setRetiredDate(retiredDate);

        Suspectors sus = modelMapper.map(suspectorDTO, Suspectors.class);


        return suspectRepo.save(sus);
    }
    private LocalDateTime CalculateRetirementDate(LocalDateTime dob,int yearsToAdd) {
        return dob.plusYears(yearsToAdd);
    }

    public List<Suspectors> searchSuspectors(String search) {
        List<Suspectors> suspectors = suspectRepo.searchSuspectors(search);
        if (suspectors.isEmpty()) {
            throw new IllegalArgumentException("No investigations found for the keyword: " + search);
        }
        return suspectors;
    }


}