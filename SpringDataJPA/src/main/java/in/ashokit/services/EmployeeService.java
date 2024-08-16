package in.ashokit.services;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import in.ashokit.entity.Employee;
import in.ashokit.repo.EmpRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmpRepo employeeRepository;

    public void saveEmployeesFromCSV(MultipartFile file) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            List<Employee> employees = new ArrayList<>();
            String[] line;
            reader.readNext(); // Skip the header if present
            while ((line = reader.readNext()) != null) {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(line[0])); // Assuming the ID is present in the CSV
                employee.setName(line[1]);
                employee.setSalary(Double.parseDouble(line[2]));
                employees.add(employee);
            }
            employeeRepository.saveAll(employees);
        }
    }
}
