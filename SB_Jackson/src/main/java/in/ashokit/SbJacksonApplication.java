package in.ashokit;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.entity.Student;

@SpringBootApplication
public class SbJacksonApplication {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(SbJacksonApplication.class, args);
		SbJacksonApplication s = new SbJacksonApplication();
		s.convertJavatoJson();
	}
	
	public void convertJavatoJson() throws Exception {
		Student stu = new Student();
		stu.setStudentAddress("Hyd");
		stu.setStudentId(1);
		stu.setStudentName("Rajpal");
		
		
		
		File f = new File("student.json");
		
		ObjectMapper obj = new ObjectMapper();
		
		//obj.writeValue(f, stu);
		
		Student value = obj.readValue(f, Student.class);
		
		System.out.println(value);
		
		System.out.println("De - Serialization Completed....");
		
	}

}
