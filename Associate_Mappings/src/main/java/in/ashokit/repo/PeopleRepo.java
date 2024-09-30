package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.People;

public interface PeopleRepo extends JpaRepository<People, Integer> {

}
