package in.ashokit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

import in.ashokit.services.EmployeeService;

@SpringBootApplication
public class SpringDataJpaApplication {
	
	
	String str = "src/main/resources/employee.csv";
	

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringDataJpaApplication.class, args);
		
		
		
		public MultipartFile convertFileToMultipartFile(File file) throws IOException {
		    FileInputStream input = new FileInputStream(file);
		    return new MockMultipartFile("file", file.getName(), 
		                                 Files.probeContentType(file.toPath()), input);
		
		
		
		
		
		
	}

}
