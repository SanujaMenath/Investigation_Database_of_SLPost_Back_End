package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.FormalInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormalInquiryRepo extends JpaRepository<FormalInquiry, String>   {
}
