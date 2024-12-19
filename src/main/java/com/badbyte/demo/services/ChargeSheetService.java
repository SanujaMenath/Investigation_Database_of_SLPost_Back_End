package com.badbyte.demo.services;

import com.badbyte.demo.entity.ChargeSheets;
import com.badbyte.demo.dto.ChargeSheetDTO;
import com.badbyte.demo.repository.ChargeSheetRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeSheetService {

    @Autowired
    private ChargeSheetRepo chargeSheetRepo;

    @Autowired
    ModelMapper modelMapper;


    public ChargeSheets saveChargeSheet(ChargeSheetDTO chargeSheet) {
        ChargeSheets chargeSheetsEntity = modelMapper.map(chargeSheet, ChargeSheets.class);
        return chargeSheetRepo.save(chargeSheetsEntity);
    }

    public List<ChargeSheets> getAllChargeSheets() {
        return chargeSheetRepo.findAll();

    }
    public ChargeSheets getChargeSheetById(Long id) {
        return chargeSheetRepo.findById(id).orElse(null);
    }

    public void deleteChargeSheet(Long id) {
        chargeSheetRepo.deleteById(id);
    }



}
