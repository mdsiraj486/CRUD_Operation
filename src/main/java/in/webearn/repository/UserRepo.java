package in.webearn.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import in.webearn.entity.User;
import in.webearn.projection.UserProjection;

public interface UserRepo extends JpaRepository<User, Integer> {
		
	List<UserProjection> findByAgeGreaterThan(Integer age);
}
