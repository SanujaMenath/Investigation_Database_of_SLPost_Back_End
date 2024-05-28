package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.InvestigationInspector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvInspectorRepo extends JpaRepository<InvestigationInspector, String> {
}
