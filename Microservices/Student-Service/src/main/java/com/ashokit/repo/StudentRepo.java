package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
