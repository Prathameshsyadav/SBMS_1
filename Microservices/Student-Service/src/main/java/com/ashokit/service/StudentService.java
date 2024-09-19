package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.Student;

public interface StudentService {
	
	public boolean addStudent(Student student);
	
	public Student getStudentById(Integer id);
	
	public List<Student> getStudent();

}
