package in.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Student;
import in.ashokit.services.StuServices;

@RestController
public class StuController {
	
	@Autowired
	private StuServices stuser;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> allStudent = stuser.getAllStudent();
		return new 
				ResponseEntity<>(allStudent,HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") Integer id) {
		Student studentById = stuser.getStudentById(id);
		return new 
				ResponseEntity<>(studentById,HttpStatus.OK);			
	}
	
	@PostMapping("/student")
	public ResponseEntity<String> saveStudent(@RequestBody Student Student){
		Boolean issaved = stuser.upsertStudent(Student);
		if(issaved) {
			return new ResponseEntity<>("Student is saved",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Student is  not saved",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/student")
	public ResponseEntity<String> updateStudent(@RequestBody Student Student){
		Boolean issaved = stuser.upsertStudent(Student);
		if(issaved) {
			return new ResponseEntity<>("Student is updated",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Student is  not updated",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStu(@PathVariable("id") Integer id) {
		stuser.deleteStudent(id);
		return new ResponseEntity<>("Student Deleted",HttpStatus.OK);			
	}
	
}
