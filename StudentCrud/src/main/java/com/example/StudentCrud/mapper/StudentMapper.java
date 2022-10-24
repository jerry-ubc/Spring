package com.example.StudentCrud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.StudentCrud.domain.Student;

@Mapper		//Tells Spring Boot this is a myBatis class
public interface StudentMapper {
	@Select("select * from student")
	List<Student> listAll();		//Automatically maps Users
	
	@Insert("insert into student(student_name, course, favourite_movie) values(#{student_name}, #{course}, #{favourite_movie})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
	void insert(Student student);
	
	@Update("update student set student_name = #{student_name}, course = #{course}, favourite_movie = #{favourite_movie} where id = #{id}")
	void update(Student student);
	
	@Delete("delete from student where id = #{id}")
	void delete(long id);
}
