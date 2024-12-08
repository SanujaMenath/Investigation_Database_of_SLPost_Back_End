package com.badbyte.demo.repository;

import com.badbyte.demo.entity.Investigations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvestigationRepo extends JpaRepository<Investigations, String> {


    @Query("SELECT i FROM Investigations i WHERE i.fileId LIKE %:fileNumber%")
    Investigations findByFileNumber(@Param("fileNumber") String fileNumber);



    @Query("SELECT i FROM Investigations i WHERE i.incident LIKE %:keyword% OR i.status LIKE %:keyword%")
    List<Investigations> searchInvestigations(@Param("keyword") String keyword);


}
