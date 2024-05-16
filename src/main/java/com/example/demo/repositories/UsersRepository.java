package com.example.demo.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	
	@Query(value = "select * from users where user =:user and password =:password", nativeQuery = true)
	public List<Map<String, Object>> verifyUser (String user, String password);
	
	@Query(value = "select user, device_id from users where user =:user", nativeQuery = true)
	public List<Map<String, Object>> userExist (String user);

}
