package com.badbyte.demo.repository;

import com.badbyte.demo.entity.InterimReports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterimReportRepo extends JpaRepository<InterimReports, String> {

}
