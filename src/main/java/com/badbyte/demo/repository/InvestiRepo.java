package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.Investigation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InvestiRepo extends JpaRepository<Investigation, Long> {


    @Query("SELECT i FROM Investigation i WHERE i.fileId LIKE %:fileNumber%")
    Investigation findByFileNumber(@Param("fileNumber") String fileNumber);

}
