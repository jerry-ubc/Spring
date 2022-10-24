package com.example.StudentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.StudentCrud.domain.Student;
import com.example.StudentCrud.mapper.StudentMapper;
//import com.example.StudentCrud.repository.StudentRepository;

//Interacts with JpaRepository (JPA) or Mapper (myBatis) that we created
@Service
public class StudentService {
//	@Autowired
//	private StudentRepository repo;
//	
//	public List<Student> listAll() {
//		return repo.findAll();
//	}
//	
//	public void save(Student student) {
//		repo.save(student);
//	}
//	
//	public Student get(long id) {		//ARE BIGINTS = LONGS?
//		return repo.findById(id).get();
//	}
//	
//	public void delete(long id) {
//		repo.deleteById(id);
//	}
	
	private StudentMapper studentMapper;
	
	public StudentService(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@GetMapping("/all")
	public List<Student> listAll() {
		return studentMapper.listAll();
	}
	
	public void update(Student student) {
//		Student newStudent = new Student();
//		newStudent.setStudent_name("Eugene");
//		newStudent.setCourse("Honours Math");
//		newStudent.setFavourite_movie("A Beautiful Mind");
//		studentMapper.insert(newStudent);
//		return studentMapper.listAll();
		
		studentMapper.update(student);
	}
	
	public void insert(Student student) {
		studentMapper.insert(student);				//MAYBE UNNECESSARY
	}
	
	public void save(Student student) {
		System.out.print("finding id: " + student.getId());
		List<Student> students = studentMapper.listAll();
		for (Student stud:students) {
			System.out.print("  cur iter id: " + stud.getId());
			if (student.getId() == stud.getId()) {
				System.out.println("found him!");
				stud.setCourse(student.getCourse());
				stud.setFavourite_movie(student.getFavourite_movie());
				stud.setStudent_name(student.getStudent_name());
				break;
			}
		}
	}
	
	public Student get(long id) {
		for (Student stud:studentMapper.listAll()) {
			if (stud.getId() == id)
				return stud;		//is it safe to return the address of the object?
		}
		return null;
	}
	
	public void delete(long id) {
		studentMapper.delete(id);
	}
}
