package com.badbyte.demo.services;

import com.badbyte.demo.Entity.Investigation_Inspectors;
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

    public List<Investigation_Inspectors> getAllInspectors() {
            return inspectorRepository.findAll();
        }

        public Investigation_Inspectors getInspectorById(String nic) {
            return inspectorRepository.findById(nic).orElse(null);
        }

        public Investigation_Inspectors saveInspector(InvInspectorDTO inspector) {
            Investigation_Inspectors inspec = modelMapper.map(inspector, Investigation_Inspectors.class);
            return inspectorRepository.save(inspec);
        }

        public void deleteInspector(String nic) {
            inspectorRepository.deleteById(nic);
        }

        public List<Investigation_Inspectors> searchInspector(String keyword) {
        List<Investigation_Inspectors> inspector = inspectorRepository.findInvestigationInspectorBy(keyword);
            if (inspector.isEmpty()) {
                throw new IllegalArgumentException("No investigations found for the keyword: " + keyword);
            }

            return inspectorRepository.findInvestigationInspectorBy(keyword);
        }

}
