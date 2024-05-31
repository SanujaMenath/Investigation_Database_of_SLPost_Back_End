package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.ChargeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChargeSheetRepo extends JpaRepository<ChargeSheet, String> {


    @Query("SELECT i FROM ChargeSheet i WHERE i.id LIKE %:keyword% OR i.aatOrderDescription LIKE %:keyword% OR i.pscOrderDescription LIKE %:keyword%")
    List<ChargeSheet> findChargeSheetByKeyword(@Param("keyword") String keyword);
}
