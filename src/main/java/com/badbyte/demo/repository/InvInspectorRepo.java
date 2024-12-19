package com.badbyte.demo.repository;

import com.badbyte.demo.entity.Investigation_Inspectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InvInspectorRepo extends JpaRepository<Investigation_Inspectors, String> {

    @Query("SELECT i FROM Investigation_Inspectors i WHERE i.nic LIKE %:keyword% OR i.name LIKE %:keyword%")
    List<Investigation_Inspectors> findInvestigationInspectorBy(@Param("keyword") String keyword);

    Optional<Investigation_Inspectors> findByNic(String nic);

}
