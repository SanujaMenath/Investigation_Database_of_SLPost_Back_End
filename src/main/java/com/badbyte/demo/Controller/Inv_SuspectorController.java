package com.badbyte.demo.Controller;

import com.badbyte.demo.Entity.Inv_Suspector;
import com.badbyte.demo.Entity.InvestigationSuspectorId;
import com.badbyte.demo.services.Inv_SuspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investigation-suspectors")
public class Inv_SuspectorController {


    @Autowired
    private Inv_SuspectorService investigationSuspectorService;

        @GetMapping
        public List<Inv_Suspector> getAllInvestigationSuspectors() {
            return investigationSuspectorService.getAllInvestigationSuspectors();
        }

        @GetMapping("/{fileId}/{NIC}")
        public Optional<Inv_Suspector> getInvestigationSuspectorById(
                @PathVariable String fileId,
                @PathVariable String NIC) {
            InvestigationSuspectorId id = new InvestigationSuspectorId(fileId, NIC);
            return investigationSuspectorService.getInvestigationSuspectorById(id);
        }

        @PostMapping
        public Inv_Suspector createInvestigationSuspector(@RequestBody Inv_Suspector investigationSuspector) {
            return investigationSuspectorService.saveInvestigationSuspector(investigationSuspector);
        }

        @DeleteMapping("/{fileNumber}/{NIC}")
        public void deleteInvestigationSuspector(@PathVariable String fileId, @PathVariable String NIC) {
            InvestigationSuspectorId id = new InvestigationSuspectorId(fileId, NIC);
            investigationSuspectorService.deleteInvestigationSuspector(id);
        }


}
