package com.badbyte.demo.repository;

import com.badbyte.demo.entity.FormalInquiries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormalInquiryRepo extends JpaRepository<FormalInquiries, String>   {

    @Query("SELECT i FROM FormalInquiries i WHERE i.id LIKE %:keyword%  ")
    List<FormalInquiries> findByKeyword(@Param("keyword") String keyword);
}
