package com.badbyte.demo.services;

import com.badbyte.demo.Entity.InvestigationInspector;
import com.badbyte.demo.dto.InvInspectorDTO;
import com.badbyte.demo.repository.InvInspectorRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvInspectorService {

    @Autowired
    private InvInspectorRepo inspectorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<InvestigationInspector> getAllInspectors() {
            return inspectorRepository.findAll();
        }

        public InvestigationInspector getInspectorById(String nic) {
            return inspectorRepository.findById(nic).orElse(null);
        }

        public InvestigationInspector saveInspector(InvInspectorDTO inspector) {
            InvestigationInspector inspec = modelMapper.map(inspector, InvestigationInspector.class);
            return inspectorRepository.save(inspec);
        }

        public void deleteInspector(String nic) {
            inspectorRepository.deleteById(nic);
        }

}
