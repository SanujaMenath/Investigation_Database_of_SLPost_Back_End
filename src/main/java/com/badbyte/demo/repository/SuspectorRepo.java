package com.badbyte.demo.repository;

import com.badbyte.demo.entity.Suspectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SuspectorRepo extends JpaRepository<Suspectors, Long> {



}
