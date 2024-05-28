package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.Inv_Suspector;
import com.badbyte.demo.Entity.InvestigationSuspectorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Inv_SuspectorRepo extends JpaRepository<Inv_Suspector, InvestigationSuspectorId> {
}
