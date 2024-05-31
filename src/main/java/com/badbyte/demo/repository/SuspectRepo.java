package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.Investigation;
import com.badbyte.demo.Entity.Suspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SuspectRepo extends JpaRepository<Suspector, String> {

  @Query("SELECT i FROM Suspector i WHERE i.nic LIKE %:keyword% OR i.name LIKE %:keyword%")
      List<Suspector> searchSuspectors(@Param("keyword") String keyword);

}
