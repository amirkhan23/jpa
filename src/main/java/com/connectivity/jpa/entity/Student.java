package com.connectivity.jpa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(name = "STUDENTNAME")
	private String studentName;
	@Column(name = "DATEOFBIRTH")
	private Date dateOfBirth;

	@ManyToOne
	@JoinColumn(name = "college_Id")
	private College college;

	@OneToMany
	private Set<Book> book = new HashSet<>();

	public Student() {
	}

	public Student(String studentName, Date dateOfBirth, College college, Set<Book> book) {
		super();
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
		this.college = college;
		this.book = book;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Set<Book> getBook() {
		return book;
	}

}
