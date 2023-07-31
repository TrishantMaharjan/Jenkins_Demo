package com.services;

import com.model.Book;

public interface BookServices {
	
	void add(Book b);
	void delete(int id);
	void edit(Book b, int id);
	void show();
	
}
