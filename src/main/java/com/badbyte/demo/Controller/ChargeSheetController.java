package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.ChargeSheet;
import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.Entity.Suspector;
import com.badbyte.demo.dto.ChargeSheetDTO;
import com.badbyte.demo.exceptions.responses.KeywordNotFoundResponse;
import com.badbyte.demo.services.ChargeSheetService;
import com.badbyte.demo.services.InvestigationService;
import com.badbyte.demo.services.SuspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charge-sheet")
@CrossOrigin
public class ChargeSheetController {

    @Autowired
    private ChargeSheetService chargeSheetService;
    @Autowired
    private InvestigationService investigationService;

    @Autowired
    private SuspectorService suspectorService;

    @GetMapping
    public List<ChargeSheet> getAllChargeSheets() {
        return chargeSheetService.getAllChargeSheets();
    }

    @GetMapping("/{id}")
    public ChargeSheet getChargeSheetById(@PathVariable String id) {
        return chargeSheetService.getChargeSheetById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createChargeSheet(@RequestBody ChargeSheetDTO chargeSheetDTO) {

        Investigation investigation = investigationService.getInvestigationByFileNumber(chargeSheetDTO.getInvestigation().getFileId());
        Suspector suspector = suspectorService.getSuspectorById(chargeSheetDTO.getSuspector().getNic());

        if (investigation == null){
            return ResponseEntity.badRequest().body("Investigation is not found in the db.");
        }

        if (suspector == null){
            return ResponseEntity.badRequest().body("Inspector is not found in the db.");
        }

        ChargeSheet saveChargeSheet = chargeSheetService.saveChargeSheet(chargeSheetDTO);

        return ResponseEntity.ok().body(saveChargeSheet);
    }

    @DeleteMapping("/{id}")
    public void deleteAssignment(@PathVariable String id) {
        chargeSheetService.deleteChargeSheet(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> getChargeSheetsByKeyword(@RequestParam String keyword) {
        try {
            if (keyword == null || keyword.isEmpty()) {
                KeywordNotFoundResponse response = new KeywordNotFoundResponse(this.getClass().getName(), "Keyword cannot be null or empty");
                return ResponseEntity.unprocessableEntity().body(response);
            }

            List<ChargeSheet> searchByOrder = chargeSheetService.getChargeSheetsByOrder(keyword);
            return ResponseEntity.ok(searchByOrder);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
