package com.badbyte.demo.services;

import com.badbyte.demo.Entity.Divisions;
import com.badbyte.demo.repository.DivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    @Autowired
    private DivisionRepo divisionRepo;
    public List<Divisions> getDivisionsByProvince() {
        return divisionRepo.findAll();
    }
}
