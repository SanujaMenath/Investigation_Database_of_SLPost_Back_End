package com.badbyte.demo.services;

import com.badbyte.demo.Entity.Investigation_Suspectors;
import com.badbyte.demo.dto.Inv_SuspectorDTO;
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

         public List<Investigation_Suspectors> getAllInvestigationSuspectors() {
            return inv_suspectorRepo.findAll();
        }

        public Optional<Investigation_Suspectors> getInvestigationSuspectorById(Long id) {
            return inv_suspectorRepo.findById(id);
        }

        public Investigation_Suspectors saveInvestigationSuspector(Inv_SuspectorDTO investigationSuspector) {
            Investigation_Suspectors invSuspector = modelMapper.map(investigationSuspector, Investigation_Suspectors.class);
            return inv_suspectorRepo.save(invSuspector);
        }

        public void deleteInvestigationSuspector(Long id) {
            inv_suspectorRepo.deleteById(id);
        }


}
