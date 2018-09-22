package com.connectivity.jpa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.connectivity.jpa.entity.College;

@Repository
@Transactional
public class CollegeApiImpl implements CollegeApi {

	@Autowired
	SessionFactory sessionFactory;

	public boolean save(College college) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			session.save(college);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public College findById(String collegeName) {

		College college = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			college = (College) session.get(College.class, collegeName);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return college;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<College> getAllCollegeList() {

		try {
			@SuppressWarnings("unused")
			List<College> list;
			Session session = sessionFactory.getCurrentSession();
			session.getTransaction().begin();
			list = (List<College>) session.createCriteria(College.class).list();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

}
