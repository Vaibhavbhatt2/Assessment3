package com.example.Assessment3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Assessment3.entity.Books;

@Repository
public interface BookRepo extends JpaRepository<Books,Long> {
	
	public List<Books> findByCategory(String category);
	
	public List<Books> findByPrice(double price);



}
