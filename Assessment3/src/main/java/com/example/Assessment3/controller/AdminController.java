package com.example.Assessment3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assessment3.entity.Admin;
import com.example.Assessment3.entity.Books;
import com.example.Assessment3.repository.AdminRepo;
import com.example.Assessment3.repository.BookRepo;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminRepo adminrepo;
	
	@Autowired
	BookRepo bookrepo;
	
	@PostMapping("/")
	public Admin postAdmin(@RequestBody Admin admin ){
		
		List<Books>book=new ArrayList<>();
		for(Books a:admin.getBook()) {
			Books books=bookrepo.findById(a.getBid()).get();
			book.add(books);	
		}
		
		admin.setBook(book);
		this.adminrepo.save(admin);
		return admin;
		
		
	}
	
	
	@GetMapping("/")
	public List<Admin> GetAdmin(@RequestBody Admin admin ){
		
		return this.adminrepo.findAll();
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdmin(@PathVariable long id,   @RequestBody Admin admin){
		Admin updateAdmin = adminrepo.findById(id).orElseThrow();
		
		updateAdmin.setName(admin.getName());
		updateAdmin.setUsername(admin.getUsername());
		adminrepo.save(updateAdmin);
		return ResponseEntity.ok(updateAdmin);
		
	}
	
	//update password	
	@PutMapping("/changepassword/{id}")
	public ResponseEntity<Admin> updatePassword(@PathVariable long id, @RequestBody Admin admin){
		Admin updateAdminPass = adminrepo.findById(id).get();
		
		updateAdminPass.setPassword(admin.getPassword());
		adminrepo.save(updateAdminPass);
		return ResponseEntity.ok(updateAdminPass);
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable("id") long id) {
		adminrepo.deleteById(id);
		return "admin deleted successfully";
		
	}
	
	

}
