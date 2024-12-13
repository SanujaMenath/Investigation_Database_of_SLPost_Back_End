package com.badbyte.demo.controller;

import com.badbyte.demo.entity.Provinces;
import com.badbyte.demo.dto.ProvinceDTO;
import com.badbyte.demo.services.ProvinceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/provinces")
@CrossOrigin(origins = "http://localhost:8080")
@PreAuthorize("isAuthenticated()")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private ModelMapper modelMapper;

    // Get all provinces

    @GetMapping("/all")
    public ResponseEntity<List<ProvinceDTO>> getAllProvinces() {
        List<Provinces> provinces = provinceService.getAllProvinces();
        List<ProvinceDTO> provinceDTOs = provinces.stream()
                .map(province -> modelMapper.map(province, ProvinceDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(provinceDTOs);
    }
}

