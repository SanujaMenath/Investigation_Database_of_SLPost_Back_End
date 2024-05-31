package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.FormalInquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormalInquiryRepo extends JpaRepository<FormalInquiry, String>   {

    @Query("SELECT i FROM FormalInquiry i WHERE i.id LIKE %:keyword%  ")
    List<FormalInquiry> findByKeyword(@Param("keyword") String keyword);
}
