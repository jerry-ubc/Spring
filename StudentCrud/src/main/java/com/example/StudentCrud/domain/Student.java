package com.example.StudentCrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String student_name;
	private String course;
	private String favourite_movie;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Long id, String student_name, String course, String favourite_movie) {
		super();
		this.id = id;
		this.student_name = student_name;
		this.course = course;
		this.favourite_movie = favourite_movie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getFavourite_movie() {
		return favourite_movie;
	}
	public void setFavourite_movie(String favourite_movie) {
		this.favourite_movie = favourite_movie;
	}
}
