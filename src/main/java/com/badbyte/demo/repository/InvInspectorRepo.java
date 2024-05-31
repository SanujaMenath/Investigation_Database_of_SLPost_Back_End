package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.InvestigationInspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvInspectorRepo extends JpaRepository<InvestigationInspector, String> {

    @Query("SELECT i FROM InvestigationInspector i WHERE i.nic LIKE %:keyword% OR i.name LIKE %:keyword%")
    List<InvestigationInspector> findInvestigationInspectorBy(@Param("keyword") String keyword);
}
