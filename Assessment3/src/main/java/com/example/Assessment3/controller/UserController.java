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
import com.example.Assessment3.entity.Users;
import com.example.Assessment3.repository.BookRepo;
import com.example.Assessment3.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	BookRepo bookrepo;
	
	@PostMapping("/")
	public Users postUser(@RequestBody Users user){
		
		List<Books>book=new ArrayList<>();
		for(Books a:user.getBook()) {
			Books books=bookrepo.findById(a.getBid()).get();
			book.add(books);	
		}
		
		user.setBook(book);
		this.userrepo.save(user);
		return user;
		
		
	}
	
	
	@GetMapping("/")
	public List<Users> GetUsers(@RequestBody Users user ){
		
		return this.userrepo.findAll();
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable long id,   @RequestBody Users user){
		Users updateUser = userrepo.findById(id).orElseThrow();
		
		updateUser.setName(user.getName());
		updateUser.setEmail(user.getEmail());
		updateUser.setAddress(user.getAddress());
		updateUser.setUsername(user.getUsername());
		updateUser.setPassword(user.getPassword());
		userrepo.save(updateUser);
		return ResponseEntity.ok(updateUser);
		
	}
	
	
	//update password
		@PutMapping("/changepassword/{id}")
		public ResponseEntity<Users> updatePassword(@PathVariable long id, @RequestBody Admin admin){
			Users updateUserPass = userrepo.findById(id).get();
			
			updateUserPass .setPassword(admin.getPassword());
			userrepo.save(updateUserPass );
			return ResponseEntity.ok(updateUserPass );
		}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		userrepo.deleteById(id);
		return "user deleted successfully";
		
	}

}
