package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.Investigation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvestiRepo extends JpaRepository<Investigation, String> {


    @Query("SELECT i FROM Investigation i WHERE i.fileId LIKE %:fileNumber%")
    Investigation findByFileNumber(@Param("fileNumber") String fileNumber);



    @Query("SELECT i FROM Investigation i WHERE i.incident LIKE %:keyword% OR i.status LIKE %:keyword%")
    List<Investigation> searchInvestigations(@Param("keyword") String keyword);


}
