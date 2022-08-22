package com.example.Assessment3.controller;

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
import com.example.Assessment3.entity.Books;
import com.example.Assessment3.repository.BookRepo;

@RestController
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	BookRepo repo;
	
	@GetMapping("/")
	public List<Books> getAllBooks() {
		return this.repo.findAll();
		
	}
	
	@PostMapping("/") 
	public Books postBooks(@RequestBody Books books) {
		this.repo.save(books);
		return books;
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Books> updateUser(@PathVariable long id,   @RequestBody Books book){
		Books updateBook = repo.findById(id).orElseThrow();
		
		updateBook.setBookName(book.getBookName());
		updateBook.setAuthor(book.getAuthor());
		updateBook.setCategory(book.getCategory());
		updateBook.setPrice(book.getPrice());
		repo.save(updateBook);
		return ResponseEntity.ok(updateBook);
		
	}
	
	//find book by category
		@GetMapping("/{category}")
		public List<Books> getBooksByCategory(@PathVariable String category){
			return this.repo.findByCategory(category);
		}
		
		//find book by price
				@GetMapping("/price/{price}")
				public List<Books> getBooksByPrice(@PathVariable double price){
					return this.repo.findByPrice(price);
				}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteBooks(@PathVariable("id") long id) {
		repo.deleteById(id);
		return "book deleted successfully";
		
	}


}
