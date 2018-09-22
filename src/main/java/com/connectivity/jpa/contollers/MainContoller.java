package com.connectivity.jpa.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.connectivity.jpa.dao.BookApiImpl;
import com.connectivity.jpa.entity.Book;

@Controller
public class MainContoller {

	@Autowired
	BookApiImpl b;

	@RequestMapping("/")
	public String getIndexPage() {
		Book book = new Book("java");
		System.out.println(b.save(book));
		Book b1 = b.findById(book.getBookId());
		System.out.println(b1.getBookName());
		return "index";
	}

}