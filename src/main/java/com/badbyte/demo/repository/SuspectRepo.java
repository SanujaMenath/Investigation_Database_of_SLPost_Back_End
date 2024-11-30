package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.Suspectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SuspectRepo extends JpaRepository<Suspectors, String> {

  @Query("SELECT i FROM Suspectors i WHERE i.nic LIKE %:keyword% OR i.name LIKE %:keyword%")
      List<Suspectors> searchSuspectors(@Param("keyword") String keyword);

}
