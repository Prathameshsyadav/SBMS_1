package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Address;
import com.ashokit.entity.Student;
import com.ashokit.feing.AddressApiClient;
import com.ashokit.service.StudentService;

@RestController		
public class StudentController {
	@Autowired
	private StudentService stuService;
	@Autowired
	private AddressApiClient addressApiClient;
	
	@PostMapping("/saveStu")
	public ResponseEntity<Boolean> saveStudent(@RequestBody Student student){
		
		List<Address> addresses = student.getAddresses();
		
		boolean saveAddress = addressApiClient.saveAddress(addresses);
	
		boolean student2 = stuService.addStudent(student);
		return new ResponseEntity<Boolean>(student2, HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") Integer id){
		List<Address> invokeAddress = addressApiClient.invokeAddress();
		Student studentById = stuService.getStudentById(id);
		studentById.setAddresses(invokeAddress);
		return new ResponseEntity<Student>(studentById, HttpStatus.OK);
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> findAllStudent(){
		List<Student> student = stuService.getStudent();
		List<Address> invokeAddress = addressApiClient.invokeAddress();
		student.forEach(s -> s.setAddresses(invokeAddress));
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}
	
	
}
