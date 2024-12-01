package com.badbyte.demo.services;

import com.badbyte.demo.Entity.Provinces;
import com.badbyte.demo.repository.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {
    @Autowired
    private ProvinceRepo provinceRepository;

    public List<Provinces> getAllProvinces() {
        return provinceRepository.findAll();
    }
}
