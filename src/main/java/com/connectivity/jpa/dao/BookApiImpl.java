package com.connectivity.jpa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.connectivity.jpa.entity.Book;

@Repository
@Transactional
public class BookApiImpl implements BookApi {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean save(Book book) {

		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			session.save(book);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Book findById(int bookId) {
		Book book = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			book = (Book) session.get(Book.class, bookId);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return book;
	}

}
