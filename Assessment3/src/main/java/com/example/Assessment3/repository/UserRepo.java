package com.example.Assessment3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Assessment3.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
	

}
