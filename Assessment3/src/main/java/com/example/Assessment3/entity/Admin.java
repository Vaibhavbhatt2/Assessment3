package com.example.Assessment3.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id")

	long adminid;
	
	@Column(name="name")
	String name;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
	 String password;
	
	
	@OneToMany
	public List<Books> book;


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admin(long adminid, String name, String username, String password, List<Books> book) {
		super();
		this.adminid = adminid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.book = book;
	}


	public long getAdminid() {
		return adminid;
	}


	public void setAdminid(long adminid) {
		this.adminid = adminid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Books> getBook() {
		return book;
	}


	public void setBook(List<Books> book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", book=" + book + "]";
	}
	
	
	


}
