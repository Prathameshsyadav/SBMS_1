package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Chocolate;

public interface ChocolateRepo extends JpaRepository<Chocolate, Integer> {

}
