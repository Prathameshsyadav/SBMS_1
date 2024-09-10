package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Student;

public interface StuRepo extends JpaRepository<Student, Integer> {

}
