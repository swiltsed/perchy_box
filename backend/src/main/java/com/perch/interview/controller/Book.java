package com.perch.interview.controller;

public class Book {

	public Book() {
		
	}
	public Book(Integer id, String title, String author, java.sql.Date date) {
	// public Book(Integer id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
	}
	
	private Integer id;
	private String title;
	private String author;
	private java.sql.Date date;

	public Integer getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public java.sql.Date getDate() {
		return date;
	}
	// @Override
	// public String toString() {
	// 	return "Employee [id=" + id + ", firstName=" + firstName
	// 			+ ", lastName=" + lastName + ", email=" + email + "]";
	// }
}
