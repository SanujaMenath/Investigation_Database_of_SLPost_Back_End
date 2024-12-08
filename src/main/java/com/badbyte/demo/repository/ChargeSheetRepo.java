package com.badbyte.demo.repository;

import com.badbyte.demo.entity.ChargeSheets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChargeSheetRepo extends JpaRepository<ChargeSheets, String> {


    @Query("SELECT i FROM ChargeSheets i WHERE i.id LIKE %:keyword% OR i.aatOrderDescription LIKE %:keyword% OR i.pscOrderDescription LIKE %:keyword%")
    List<ChargeSheets> findChargeSheetByKeyword(@Param("keyword") String keyword);
}
