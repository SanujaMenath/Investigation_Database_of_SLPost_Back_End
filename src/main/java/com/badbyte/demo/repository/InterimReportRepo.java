package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.InterimReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterimReportRepo extends JpaRepository<InterimReport, String> {

}
