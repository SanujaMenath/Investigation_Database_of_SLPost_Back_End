package com.badbyte.demo.controller;

import com.badbyte.demo.entity.ChargeSheets;
import com.badbyte.demo.entity.Investigations;
import com.badbyte.demo.entity.Suspectors;
import com.badbyte.demo.dto.ChargeSheetDTO;
import com.badbyte.demo.services.ChargeSheetService;
import com.badbyte.demo.services.InvestigationService;
import com.badbyte.demo.services.SuspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charge-sheet")
@CrossOrigin(origins = "http://localhost:8080")
public class ChargeSheetController {

    @Autowired
    private ChargeSheetService chargeSheetService;
    @Autowired
    private InvestigationService investigationService;

    @Autowired
    private SuspectorService suspectorService;

    @GetMapping
    public List<ChargeSheets> getAllChargeSheets() {
        return chargeSheetService.getAllChargeSheets();
    }

    @GetMapping("/{id}")
    public ChargeSheets getChargeSheetById(@PathVariable String id) {
        return chargeSheetService.getChargeSheetById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createChargeSheet(@RequestBody ChargeSheetDTO chargeSheetDTO) {

        Investigations investigations = investigationService.getInvestigationByFileNumber(chargeSheetDTO.getInvestigation().getFileId());
        Suspectors suspectors = suspectorService.getSuspectorById(chargeSheetDTO.getSuspector().getNic());

        if (investigations == null){
            return ResponseEntity.badRequest().body("Investigation is not found in the db.");
        }

        if (suspectors == null){
            return ResponseEntity.badRequest().body("Inspector is not found in the db.");
        }

        ChargeSheets saveChargeSheets = chargeSheetService.saveChargeSheet(chargeSheetDTO);

        return ResponseEntity.ok().body(saveChargeSheets);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable String id) {
        chargeSheetService.deleteChargeSheet(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> getChargeSheetsByKeyword(@RequestParam String keyword) {
        try {
//            if (keyword == null || keyword.isEmpty()) {
//                KeywordNotFoundResponse response = new KeywordNotFoundResponse(this.getClass().getName(), "Keyword cannot be null or empty");
//                return ResponseEntity.unprocessableEntity().body(response);
//            }

            List<ChargeSheets> searchByOrder = chargeSheetService.getChargeSheetsByOrder(keyword);
            return ResponseEntity.ok(searchByOrder);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
