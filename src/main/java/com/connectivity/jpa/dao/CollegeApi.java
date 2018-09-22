package com.connectivity.jpa.dao;

import java.util.List;

import com.connectivity.jpa.entity.College;

public interface CollegeApi {
	
	public boolean save(College college);
	public College findById(String collegeName);
	public List<College> getAllCollegeList();

}
