package com.ashokit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.Student;
import com.ashokit.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		 Student save = studentRepo.save(student);
		 return save.getId()!=null;
	}

	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}

	@Override
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

}
