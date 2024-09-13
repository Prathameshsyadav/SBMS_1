package in.ashokit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Student;
import in.ashokit.repo.StuRepo;

@Service
public class StuServices {
	@Autowired
	private StuRepo stuRepo;
	
	public Boolean upsertStudent(Student s) {
		 Student stu = stuRepo.save(s);
		 return stu.getId() != null;
	}
	
	public List<Student> getAllStudent(){
		return stuRepo.findAll();
	}
	
	public Student getStudentById(Integer id) {
		return stuRepo.findById(id).get();
	}
	
	public String deleteStudent(Integer id) {
		if(stuRepo.existsById(id)) {
			stuRepo.deleteById(id);
			return "Student got deleted";
		}else {
			return "Incorrect Id";
		}
		
	}
	

}
