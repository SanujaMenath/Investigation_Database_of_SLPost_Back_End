package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.Divisions;
import com.badbyte.demo.dto.DivisionDTO;
import com.badbyte.demo.services.DivisionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/divisions")
@CrossOrigin(origins = "*")
public class DivisionController {

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private ModelMapper modelMapper;

    // Get divisions by province ID
    @GetMapping("/all")
    public ResponseEntity<List<DivisionDTO>> getDivisionsByProvince() {
        List<Divisions> divisions = divisionService.getDivisionsByProvince();
        List<DivisionDTO> divisionDTOs = divisions.stream()
                .map(division -> modelMapper.map(division, DivisionDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(divisionDTOs);
    }
}

