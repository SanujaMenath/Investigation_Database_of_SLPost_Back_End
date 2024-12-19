package com.badbyte.demo.controller;

import com.badbyte.demo.entity.ChargeSheets;

import com.badbyte.demo.services.ChargeSheetService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charge-sheet")
@CrossOrigin(origins = "http://localhost:8080")
public class ChargeSheetController {

    @Autowired
    private  ChargeSheetService chargeSheetService;


    @GetMapping
    public List<ChargeSheets> getAllChargeSheets() {
        return chargeSheetService.getAllChargeSheets();
    }

    @GetMapping("/{id}")
    public ChargeSheets getChargeSheetById(@PathVariable Long id) {
        return chargeSheetService.getChargeSheetById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable Long id) {
        chargeSheetService.deleteChargeSheet(id);
    }



}
