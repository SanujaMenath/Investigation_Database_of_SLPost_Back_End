package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.Inv_Suspector;
import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.Entity.Suspector;
import com.badbyte.demo.dto.Inv_SuspectorDTO;
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
public class Inv_SuspectorController {


    @Autowired
    private Inv_SuspectorService investigationSuspectorService;
    @Autowired
    private InvestigationService investigationService;
    @Autowired
    private SuspectorService suspectorService;

    @GetMapping
        public List<Inv_Suspector> getAllInvestigationSuspectors() {
            return investigationSuspectorService.getAllInvestigationSuspectors();
        }

        @GetMapping("/{id}")
        public Optional<Inv_Suspector> getInvestigationSuspectorById(@PathVariable Long id) {
            return investigationSuspectorService.getInvestigationSuspectorById(id);
        }

        @PostMapping
        public ResponseEntity<Object> createInvestigationSuspector(@RequestBody Inv_SuspectorDTO  inv_suspectorDTO) {

            Investigation investigation = investigationService.getInvestigationByFileNumber(inv_suspectorDTO.getInvestigation().getFileId());
            Suspector suspector = suspectorService.getSuspectorById(inv_suspectorDTO.getSuspector().getNic());

            if (investigation == null){
                return ResponseEntity.badRequest().body("Investigation is not found in the db.");
            }

            if (suspector == null){
                return ResponseEntity.badRequest().body("Inspector is not found in the db.");
            }

            Inv_Suspector saveInvSus = investigationSuspectorService.saveInvestigationSuspector(inv_suspectorDTO);

            return ResponseEntity.ok().body(saveInvSus);
        }

        @DeleteMapping("/{id}")
        public void deleteInvestigationSuspector(@PathVariable Long id) {

            investigationSuspectorService.deleteInvestigationSuspector(id);
        }


}
