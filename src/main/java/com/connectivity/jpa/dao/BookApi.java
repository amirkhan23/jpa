package com.connectivity.jpa.dao;

import com.connectivity.jpa.entity.Book;

public interface BookApi {
	
	public boolean save(Book book);
	public Book findById(int bookId);

}
