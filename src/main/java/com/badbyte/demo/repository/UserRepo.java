package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
}
