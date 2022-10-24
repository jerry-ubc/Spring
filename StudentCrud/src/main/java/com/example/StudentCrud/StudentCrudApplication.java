package com.example.StudentCrud;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.StudentCrud.domain.Student;

@MappedTypes(Student.class)
@MapperScan("com.example.StudentCrud.mapper")
@SpringBootApplication
public class StudentCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCrudApplication.class, args);
	}

}
