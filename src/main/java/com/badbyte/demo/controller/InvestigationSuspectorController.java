package com.badbyte.demo.controller;

import com.badbyte.demo.dto.InvestigationSuspectorDTO;
import com.badbyte.demo.entity.Investigation_Suspectors;
import com.badbyte.demo.entity.Investigations;
import com.badbyte.demo.entity.Suspectors;
import com.badbyte.demo.services.Inv_SuspectorService;
import com.badbyte.demo.services.InvestigationService;
import com.badbyte.demo.services.SuspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investigation-suspectors")
@CrossOrigin(origins = "http://localhost:8080")
public class InvestigationSuspectorController {


    @Autowired
    private Inv_SuspectorService investigationSuspectorService;
    @Autowired
    private InvestigationService investigationService;
    @Autowired
    private SuspectorService suspectorService;

    @GetMapping
        public List<Investigation_Suspectors> getAllInvestigationSuspectors() {
            return investigationSuspectorService.getAllInvestigationSuspectors();
        }

        @GetMapping("/{id}")
        public Optional<Investigation_Suspectors> getInvestigationSuspectorById(@PathVariable Long id) {
            return investigationSuspectorService.getInvestigationSuspectorById(id);
        }

    @PostMapping
    public ResponseEntity<Object> createInvestigationSuspector(@RequestBody InvestigationSuspectorDTO investigation_suspectorDTO) {

        // Fetch the Investigation entity using the fileId from the DTO
        Investigations investigations = investigationService.getInvestigationById(investigation_suspectorDTO.getInvestigationId());

        // Fetch the Suspector entity using the id instead of nic, as we changed the Suspector entity's PK
        Long suspectorId = investigation_suspectorDTO.getSuspectorId();
        Suspectors suspectors = suspectorService.getSuspectorById(suspectorId);

        // Check if the investigation exists
        if (investigations == null) {
            return ResponseEntity.badRequest().body("Investigation not found in the database.");
        }

        // Check if the suspector exists
        if (suspectors == null) {
            return ResponseEntity.badRequest().body("Suspector not found in the database.");
        }

        // Save the Investigation_Suspectors entity
        Investigation_Suspectors savedInvestigationSuspector = investigationSuspectorService.saveInvestigationSuspector(investigation_suspectorDTO);

        // Return the saved entity
        return ResponseEntity.ok().body(savedInvestigationSuspector);
    }


    @DeleteMapping("/{id}")
        public void deleteInvestigationSuspector(@PathVariable Long id) {

            investigationSuspectorService.deleteInvestigationSuspector(id);
        }


}
