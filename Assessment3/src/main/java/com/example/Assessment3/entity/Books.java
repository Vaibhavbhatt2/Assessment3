package com.example.Assessment3.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	 long bid;
	
	@Column(name="name")
	 String bookName;
	
	@Column(name="author")
	 String author;
	
	@Column(name="category")
	 String category;
	
	@Column(name="price")
	 double price;

	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(long bid, String bookName, String author, String category, double price) {
		super();
		this.bid = bid;
		this.bookName = bookName;
		this.author = author;
		this.category = category;
		this.price = price;
	}

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

	@Override
	public String toString() {
		return "Books [bid=" + bid + ", bookName=" + bookName + ", author=" + author + ", category=" + category
				+ ", price=" + price + "]";
	}

	
	
	
	
}
