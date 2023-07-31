package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.model.Book;

public class BookServicesImpl implements BookServices {
	
	public void add(Book b) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
			String sql = "insert into book(Name,Author,Publisher,Edition) values('"+b.getName()+"', '"+b.getAuthor()+"', '"+b.getPublisher()+"', '"+b.getEdition()+"')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Book added successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
			String sql = "delete from book where ID = '"+id+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Book deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void edit(Book b, int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
			String sql = "update book set Name = '"+b.getName()+"', Author = '"+b.getAuthor()+"', Publisher = '"+b.getPublisher()+"', Edition = '"+b.getEdition()+"' where ID = '"+id+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Book updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void show() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");
			String sql = "select * from book";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println("Book ID = "+rs.getInt("ID"));
				System.out.println("Book Name = "+rs.getString("Name"));
				System.out.println("Book Author = "+rs.getString("Author"));
				System.out.println("Book Publisher = "+rs.getString("Publisher"));
				System.out.println("Book Edition = "+rs.getInt("Edition"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
