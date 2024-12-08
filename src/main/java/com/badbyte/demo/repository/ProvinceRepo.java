package com.badbyte.demo.repository;

import com.badbyte.demo.entity.Provinces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepo extends JpaRepository<Provinces, Long> {
}