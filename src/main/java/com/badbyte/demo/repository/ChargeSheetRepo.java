package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.ChargeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeSheetRepo extends JpaRepository<ChargeSheet, String> {
}
