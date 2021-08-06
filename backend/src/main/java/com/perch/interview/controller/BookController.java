package com.perch.interview.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// import org.json.JSONObject;

// import com.google.gson.Gson;

// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;



@CrossOrigin //(origins = "http://localhost:8080")
@RestController

public class BookController {
	@Value("${spring.datasource.url}")
	private String dburl;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("/books")
	public List<Book> getBookResultsJson() {
		List<Book> bookList = new ArrayList<Book>();

		String query = "SELECT * FROM BOOK";
		
		try (Connection con = DriverManager.getConnection(dburl, userName, password); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Book boook = new Book(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("AUTHOR"), rs.getDate("PUBLISHDATE"));
				// JsonResults.put("Title", rs.getString("Title"));
				// JsonResults.put("Author", rs.getString("Author"));
				// JsonResults.put("Date", rs.getDate("PublishDate"));
				bookList.add(boook);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return bookList;
	}



	// @RequestMapping(method = RequestMethod.GET, path = "/")




    // public static JSONObject getBookResultsJson(Connection con) throws SQLException {
	// 	JSONObject JsonResults = new JSONObject();
		
	// 	String query = "SELECT B.* FROM [dbo].[book] B";
	// 	try (Statement stmt = con.createStatement()) {
	// 		ResultSet rs = stmt.executeQuery(query);
	// 		while (rs.next()) {
	// 		// JSONObject result = new JSONObject();
	// 			JsonResults.put("Title", rs.getString("Title"));
	// 			JsonResults.put("Author", rs.getString("Author"));
	// 			JsonResults.put("Date", rs.getDate("PublishDate"));
	// 		// JsonResults.put(result);
	// 		}
	// 	} catch (SQLException e) {
	// 		System.out.println(e);
	// 	}
	
	// 	return JsonResults;
	// }	

}
