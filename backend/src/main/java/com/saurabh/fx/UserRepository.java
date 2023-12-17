package com.saurabh.fx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Model, Long>{
   
	boolean existsByEmail(String email);
}
