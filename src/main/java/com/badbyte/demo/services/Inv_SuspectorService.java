package com.badbyte.demo.services;

import com.badbyte.demo.entity.Investigation_Suspectors;
import com.badbyte.demo.dto.InvestigationSuspectorDTO;
import com.badbyte.demo.repository.InvestigationSuspectorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Inv_SuspectorService {


        @Autowired
        private InvestigationSuspectorRepo investigation_suspectorRepo;

        @Autowired
        ModelMapper modelMapper;

         public List<Investigation_Suspectors> getAllInvestigationSuspectors() {
            return investigation_suspectorRepo.findAll();
        }

        public Optional<Investigation_Suspectors> getInvestigationSuspectorById(Long id) {
            return investigation_suspectorRepo.findById(id);
        }

        public Investigation_Suspectors saveInvestigationSuspector(InvestigationSuspectorDTO investigationSuspector) {
            Investigation_Suspectors invSuspector = modelMapper.map(investigationSuspector, Investigation_Suspectors.class);
            return investigation_suspectorRepo.save(invSuspector);
        }

        public void deleteInvestigationSuspector(Long id) {
            investigation_suspectorRepo.deleteById(id);
        }


}
