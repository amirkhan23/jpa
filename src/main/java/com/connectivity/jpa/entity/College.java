package com.connectivity.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;
	@Column(name = "COLLEGENAME", unique = true)
	private String collegeName;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Book> book = new HashSet<>();
	@OneToMany(mappedBy = "college")
	private Set<Student> student = new HashSet<>();

	public College() {

	}

	public College(String collegeName, Set<Book> book, Set<Student> student) {
		super();
		this.collegeName = collegeName;
		this.book = book;
		this.student = student;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Set<Book> getBook() {
		return book;
	}

	public Set<Student> getStudent() {
		return student;
	}

}
