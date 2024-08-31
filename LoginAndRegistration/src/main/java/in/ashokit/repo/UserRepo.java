package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.User;
import jakarta.transaction.Transactional;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("update User set password=:password where id=:userId")
	public Integer updatePassword(Integer userId,String password);
}
