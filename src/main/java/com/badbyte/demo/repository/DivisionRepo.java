package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DivisionRepo extends JpaRepository<Divisions, Long> {
    List<Divisions> findByProvinceId(Long provinceId);
}
