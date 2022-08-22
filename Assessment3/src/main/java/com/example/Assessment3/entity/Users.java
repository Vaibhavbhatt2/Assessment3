package com.example.Assessment3.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	long userid;
	
	@Column(name="Username")

	 String username;
	
	@Column(name="name")
	 String name;

	
	@Column(name="email")
	 String email;
	
	@Column(name="password")
	 String password;
	
	
	@Column(name="address")
	 String address;
	
	@ManyToMany
	List<Books>book;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(long userid, String username, String name, String email, String password, String address,
			List<Books> book) {
		super();
		this.userid = userid;
		this.username = username;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.book = book;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", book=" + book + "]";
	}
	
	
	

}
