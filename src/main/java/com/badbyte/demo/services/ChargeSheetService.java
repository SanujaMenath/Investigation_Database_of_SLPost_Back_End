package com.badbyte.demo.services;

import com.badbyte.demo.Entity.ChargeSheet;
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

    public ChargeSheet saveChargeSheet(ChargeSheetDTO chargeSheet) {
        ChargeSheet chargeSheetEntity = modelMapper.map(chargeSheet, ChargeSheet.class);
        return chargeSheetRepo.save(chargeSheetEntity);
    }

    public List<ChargeSheet> getAllChargeSheets() {
        return chargeSheetRepo.findAll();

    }
    public ChargeSheet getChargeSheetById(String id) {
        return chargeSheetRepo.findById(id).orElse(null);
    }

    public void deleteChargeSheet(String id) {
        chargeSheetRepo.deleteById(id);
    }

}
