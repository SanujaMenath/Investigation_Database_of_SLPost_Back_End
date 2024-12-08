package com.badbyte.demo.repository;

import com.badbyte.demo.entity.Investigation_Suspectors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Inv_SuspectorRepo extends JpaRepository<Investigation_Suspectors, Long> {
}
