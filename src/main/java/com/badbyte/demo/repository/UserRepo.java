package com.badbyte.demo.repository;

import com.badbyte.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
