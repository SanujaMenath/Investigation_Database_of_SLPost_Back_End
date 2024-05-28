package com.badbyte.demo.services;

import com.badbyte.demo.Entity.Inv_Suspector;
import com.badbyte.demo.Entity.InvestigationSuspectorId;
import com.badbyte.demo.repository.Inv_SuspectorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Inv_SuspectorService {


        @Autowired
        private Inv_SuspectorRepo inv_suspectorRepo;

        @Autowired
        ModelMapper modelMapper;

         public List<Inv_Suspector> getAllInvestigationSuspectors() {
            return inv_suspectorRepo.findAll();
        }

        public Optional<Inv_Suspector> getInvestigationSuspectorById(InvestigationSuspectorId id) {
            return inv_suspectorRepo.findById(id);
        }

        public Inv_Suspector saveInvestigationSuspector(Inv_Suspector investigationSuspector) {
            Inv_Suspector invSuspector = modelMapper.map(investigationSuspector, Inv_Suspector.class);
            return inv_suspectorRepo.save(investigationSuspector);
        }

        public void deleteInvestigationSuspector(InvestigationSuspectorId id) {
            inv_suspectorRepo.deleteById(id);
        }


}
